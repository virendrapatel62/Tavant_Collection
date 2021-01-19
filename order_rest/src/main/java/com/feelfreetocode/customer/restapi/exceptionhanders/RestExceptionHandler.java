package com.feelfreetocode.customer.restapi.exceptionhanders;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.feelfreetocode.customer.restapi.errorresponse.ApiError;

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
		apiError.addValidationError(ex.getFieldErrors());

		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	

}
