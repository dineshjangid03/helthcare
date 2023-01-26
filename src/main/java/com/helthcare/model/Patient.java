package com.helthcare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 3, message = "Name should be at least 3 characters")
	private String name;

	@Size(max = 20, message = "City should be at max 20 characters")
	private String city;
	
	@Email(message =  "Email is not in 'example@email.com' format")
	private String email; 
	
	@Pattern(regexp = "[0-9]{10}", message = "Phone number should be at least 10 number")
	private String phoneNumber;
	
	private String symptom;

}
