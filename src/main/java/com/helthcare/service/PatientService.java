package com.helthcare.service;

import java.util.List;

import com.helthcare.exception.DoctorException;
import com.helthcare.exception.PatientException;
import com.helthcare.model.Doctor;
import com.helthcare.model.Patient;

public interface PatientService {
	
	public Patient addPatient(Patient patient)throws PatientException;
	
	public Patient deletePatient(Integer patientId)throws PatientException;
	
	public List<Doctor> suggestDoctors(Integer patientId) throws PatientException, DoctorException ;

	public List<Patient> allPatient()throws PatientException;
	
}
