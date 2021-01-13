package com.feelfreetocode.restapi.handlers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.feelfreetocode.restapi.errorresponce.ApiError;

import lombok.extern.slf4j.Slf4j;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		ex.getFieldErrors().forEach(apiError::addValidationError);
		

		return new ResponseEntity<>( apiError , apiError.getHttpStatus());
	}
}
