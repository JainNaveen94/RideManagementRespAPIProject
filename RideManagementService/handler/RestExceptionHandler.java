package com.nagarro.driver.model.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nagarro.driver.model.ErrorModel;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorModel> handleException(Exception exception) {
		ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<ErrorModel>(error, HttpStatus.BAD_REQUEST);
	}

}
