package com.feelfreetocode.restapi.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.feelfreetocode.restapi.errorresponce.ErrorResponse;
import com.feelfreetocode.restapi.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.restapi.exceptions.ValidationException;

//@ControllerAdvice
public class EmployeeRestControllerAdvice {

//	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(
			EmployeeNotFoundException employeeNotFoundException, WebRequest request) {

		System.out.println("----EmployeeRestControllerAdvice.handleEmployeeNotFoundException()-------");
		List<String> details = new ArrayList<String>();
		details.add(employeeNotFoundException.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse(employeeNotFoundException.getMessage(), details);
		return new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ErrorResponse> handleValidationException(
			ValidationException validationException, WebRequest request) {

		System.out.println("------EmployeeRestControllerAdvice.handleValidationException()");
		List<String> details = new ArrayList<String>();
		details.add(validationException.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse(validationException.getMessage(), details);
		return new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.NOT_FOUND);
	}
}
