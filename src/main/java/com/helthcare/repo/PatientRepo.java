package com.helthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helthcare.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
