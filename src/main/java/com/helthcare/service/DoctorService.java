package com.helthcare.service;

import java.util.List;

import com.helthcare.exception.DoctorException;
import com.helthcare.model.Doctor;

public interface DoctorService {
	
	public Doctor addDoctor(Doctor doctor)throws DoctorException;
	
	public Doctor deleteDoctor(Integer doctorId)throws DoctorException;
	
	public List<Doctor> allDoctor()throws DoctorException;

}
