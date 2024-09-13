package com.example.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.model.ErrorResonseDTO;

import customexception.FieldRequiredException;


@ControllerAdvice

public class ControllerAdivsor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
        public ResponseEntity<Object> handleArithmeticException(
        		ArithmeticException ex , WebRequest request){
        	
        	ErrorResonseDTO errorDTO = new ErrorResonseDTO();
        	errorDTO.setError(ex.getMessage());
        	List<String> details = new ArrayList<>();
        	details.add("So nguyen lam sao chia het duoc cho 0");
        	errorDTO.setDetail(details);
        	
        	return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(
    		FieldRequiredException ex , WebRequest request){
    	
    	ErrorResonseDTO errorDTO = new ErrorResonseDTO();
    	errorDTO.setError(ex.getMessage());
    	List<String> details = new ArrayList<>();
    	details.add("check lai name of numberbasement");
    	errorDTO.setDetail(details);
    	
    	return new ResponseEntity<>(errorDTO, HttpStatus.BAD_GATEWAY);
    }
}
