package com.helthcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helthcare.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{
	
	public List<Doctor> findByCityAndSpeciality(String city, String speciality);
	
}
