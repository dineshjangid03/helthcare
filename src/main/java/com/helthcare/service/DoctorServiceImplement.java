package com.helthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthcare.exception.DoctorException;
import com.helthcare.model.Doctor;
import com.helthcare.repo.DoctorRepo;

@Service
public class DoctorServiceImplement implements DoctorService{
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Override
	public Doctor addDoctor(Doctor doctor) throws DoctorException {

		String city=doctor.getCity();
		if(city.equalsIgnoreCase("Delhi")||city.equalsIgnoreCase("Noida")||city.equalsIgnoreCase("Faridabad")) {
			String specialist=doctor.getSpeciality();
			if(specialist.equalsIgnoreCase("Orthopedic")||specialist.equalsIgnoreCase("Gynecology")||specialist.equalsIgnoreCase("Dermatology")||specialist.equalsIgnoreCase("ENT")) {
				return doctorRepo.save(doctor);
			}
			else {
				throw new DoctorException("Speciality can have 4 values i.e. Orthopedic, Gynecology, Dermatology, ENT specialist");
			}
		}
		else {
			throw new DoctorException("City can have 3 values only i.e. Delhi, Noida, Faridabad");
			
		}

	}

	@Override
	public Doctor deleteDoctor(Integer doctorId) throws DoctorException {
		Optional<Doctor> saved=doctorRepo.findById(doctorId);
		if(saved.isEmpty()) {
			throw new DoctorException("Doctor not found with id "+doctorId);
		}
		Doctor doctor=saved.get();
		doctorRepo.delete(doctor);
		return doctor;
	}

	@Override
	public List<Doctor> allDoctor() throws DoctorException {
		List<Doctor>list=doctorRepo.findAll();
		if(list.isEmpty()) {
			throw new DoctorException("no Doctor found");
		}
		return list;
	}

}
