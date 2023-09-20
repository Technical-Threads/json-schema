package com.technicalthreads.jsonschema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.technicalthreads.jsonschema.model.Error;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler(SchemaValidationException.class)
		public ResponseEntity<Error> handleSchemaValidationError(SchemaValidationException ex){
			Error error=new Error(HttpStatus.BAD_REQUEST.name(),ex.getMessage());
			System.out.print("in controller advisor");
					return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleAllError(Exception ex){
		Error error=new Error(HttpStatus.BAD_REQUEST.name(),ex.getMessage());
		System.out.print("in controller advisor");
				return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
