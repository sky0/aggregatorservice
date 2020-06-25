package com.nagarro.micro.aggregator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<String> userNotFound(UserNotFoundException e){
		
		return new ResponseEntity<String>(e.getMessage()+e.getId(),HttpStatus.NOT_FOUND);
	}

}
