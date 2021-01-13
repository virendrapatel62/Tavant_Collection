package com.feelfreetocode.restapi.exceptions;

import java.util.NoSuchElementException;

public class EmployeeNotFoundException extends NoSuchElementException{

	private static final String message  = "No such Employee";
	
	public EmployeeNotFoundException() {
		super(message);
	}
	
	public EmployeeNotFoundException(String message ) {
		super(message);
	}

}
