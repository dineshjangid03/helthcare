package com.helthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helthcare.exception.DoctorException;
import com.helthcare.exception.PatientException;
import com.helthcare.model.Doctor;
import com.helthcare.model.Patient;
import com.helthcare.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) throws PatientException{
		Patient saved=patientService.addPatient(patient);
		return new ResponseEntity<Patient>(saved,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("patientId") Integer patientId) throws PatientException{
		Patient saved=patientService.deletePatient(patientId);
		return new ResponseEntity<Patient>(saved,HttpStatus.OK);
	}
	
	
	@GetMapping("/suggestDoctors/{patientId}")
	public ResponseEntity<List<Doctor>> suggestDoctors(@PathVariable("patientId") Integer patientId) throws DoctorException, PatientException {
		List<Doctor> list=patientService.suggestDoctors(patientId);
		return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/allPatient")
	public ResponseEntity<List<Patient>> allDoctor() throws PatientException {
		List<Patient> list=patientService.allPatient();
		return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	}

}
