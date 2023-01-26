package com.helthcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthcare.exception.DoctorException;
import com.helthcare.exception.PatientException;
import com.helthcare.model.Doctor;
import com.helthcare.model.Patient;
import com.helthcare.repo.DoctorRepo;
import com.helthcare.repo.PatientRepo;

@Service
public class PatientServiceImplement implements PatientService{
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	

	@Override
	public Patient addPatient(Patient patient) throws PatientException {
		
		String symptom=patient.getSymptom();
		
		if(symptom.equalsIgnoreCase("arthritis")||symptom.equalsIgnoreCase("backpain")||symptom.equalsIgnoreCase("tissue injuries")
				||symptom.equalsIgnoreCase("dysmenorrhea")||symptom.equalsIgnoreCase("skin infection")||symptom.equalsIgnoreCase("skin burn")
				||symptom.equalsIgnoreCase("ear pain")) {
			
			return patientRepo.save(patient);
			
		}
		else {
			throw new PatientException("Symptom can have Arthritis, Backpain, Tissue injuries, Dysmenorrhea, Skin infection, skin burn, Ear pain values only");
		}

	}
	

	@Override
	public Patient deletePatient(Integer patientId) throws PatientException {
		Optional<Patient> saved=patientRepo.findById(patientId);
		if(saved.isEmpty()) {
			throw new PatientException("Doctor not found with id "+patientId);
		}
		Patient patient=saved.get();
		patientRepo.delete(patient);
		return patient;
	}
	
	@Override
	public List<Doctor> suggestDoctors(Integer patientId) throws PatientException, DoctorException {
		
	    Patient patient=patientRepo.findById(patientId).orElseThrow(() -> new PatientException("Patient not found"));
	    String patientCity=patient.getCity();
	    String patientSymptom=patient.getSymptom().toLowerCase();
	    List<Doctor> doctors=new ArrayList<>();
	    
	    switch (patientSymptom) {
	        case "arthritis":
	        case "aackpain":
	        case "tissue injuries":
	            doctors=doctorRepo.findByCityAndSpeciality(patientCity, "Orthopedic");
	            break;
	        case "dysmenorrhea":
	            doctors=doctorRepo.findByCityAndSpeciality(patientCity, "Gynecology");
	            break;
	        case "skin infection":
	        case "skin burn":
	            doctors=doctorRepo.findByCityAndSpeciality(patientCity, "Dermatology");
	            break;
	        case "ear pain":
	            doctors=doctorRepo.findByCityAndSpeciality(patientCity, "ENT");
	            break;
	        default:
	            throw new PatientException("Invalid symptom");
	    }
	    
	    if (doctors.isEmpty()) {
	    	
	        if (patientCity.equalsIgnoreCase("Delhi") || patientCity.equalsIgnoreCase("Noida") || patientCity.equalsIgnoreCase("Faridabad")) {
	            throw new DoctorException("There isn't any doctor present at your location for your symptom");
	        }
	        else {
	            throw new DoctorException("We are still waiting to expand to your location");
	        }
	        
	    }
	    
	    return doctors;
	    
	}


	@Override
	public List<Patient> allPatient() throws PatientException {
		List<Patient> list=patientRepo.findAll();
		if(list.isEmpty()) {
			throw new PatientException("no Patient found");
		}
		return list;
	}


}
