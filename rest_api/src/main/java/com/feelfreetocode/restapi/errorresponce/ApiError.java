package com.feelfreetocode.restapi.errorresponce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.bind.util.ValidationEventCollector;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;
	private String message;
	private String debugMessage;
	private HttpStatus httpStatus;
	private List<ApiSubError> subErrors;

	public ApiError(String message, String debugMessage, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.debugMessage = debugMessage;
		this.httpStatus = httpStatus;
	}

	public ApiError(HttpStatus httpStatus, Throwable throwable) {
		super();
		this.httpStatus = httpStatus;
		this.debugMessage = throwable.getLocalizedMessage();
	}
	
	public ApiError(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}

	private void addSubError(ApiSubError error) {
		if (subErrors == null)
			subErrors = new ArrayList<ApiSubError>();

		subErrors.add(error);
	}

	public void addValidationError(String object, String field, Object rejectedValue, String message) {
		addSubError(new ApiValidationError(object, field, rejectedValue, message));
	}

	public void addValidationError(FieldError error) {

		addSubError(new ApiValidationError(error.getObjectName(), error.getField(), error.getRejectedValue(),
				error.getDefaultMessage()));
	}

	public void addValidationError(ConstraintViolation<?> constraintViolation) {
		this.addValidationError(constraintViolation.getRootBeanClass().getSimpleName(),
				((PathImpl)constraintViolation.getPropertyPath()).asString(), constraintViolation.getInvalidValue(),
				constraintViolation.getMessage());
	}

	public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
		constraintViolations.forEach(this::addValidationError);
	}

}
