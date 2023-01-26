package com.helthcare.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.helthcare.dto.ExceptionDTO;


@ControllerAdvice
public class GlobalExceptinHandler {
	
	
	@ExceptionHandler(DoctorException.class)
	public ResponseEntity<ExceptionDTO> doctorException(DoctorException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateTime(LocalDateTime.now());
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionDTO>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PatientException.class)
	public ResponseEntity<ExceptionDTO> patientException(PatientException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateTime(LocalDateTime.now());
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionDTO>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDTO> validationException(MethodArgumentNotValidException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateTime(LocalDateTime.now());
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionDTO>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionDTO> NullPointerException(NullPointerException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateTime(LocalDateTime.now());
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionDTO>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDTO> noHandlerException(NoHandlerFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateTime(LocalDateTime.now());
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionDTO>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> masterException(Exception e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateTime(LocalDateTime.now());
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionDTO>(err,HttpStatus.BAD_REQUEST);
		
	}
	

}
