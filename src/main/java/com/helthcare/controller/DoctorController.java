package com.helthcare.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.helthcare.model.Doctor;
import com.helthcare.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody @Valid Doctor doctor) throws DoctorException {
		Doctor saved=doctorService.addDoctor(doctor);
		return new ResponseEntity<Doctor>(saved,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{doctorId}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable("doctorId") Integer doctorId) throws DoctorException {
		Doctor saved=doctorService.deleteDoctor(doctorId);
		return new ResponseEntity<Doctor>(saved,HttpStatus.OK);
	}
	
	@GetMapping("/allDoctors")
	public ResponseEntity<List<Doctor>> allDoctor() throws DoctorException {
		List<Doctor> list=doctorService.allDoctor();
		return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	}
	
}
