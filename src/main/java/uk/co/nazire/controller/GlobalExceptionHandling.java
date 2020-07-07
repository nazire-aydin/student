package uk.co.nazire.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import uk.co.nazire.exception.DataNotFoundException;
import uk.co.nazire.model.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetails dataNotFoundExceptionHandler(DataNotFoundException ex,WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),request.getDescription(false),
				                                     new Date(),HttpStatus.NOT_FOUND.value());
				
		return errorDetails;
	}

}
