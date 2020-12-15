package com.tavant.collection.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDepartmentIdException extends Exception {

	public InvalidDepartmentIdException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		return super.toString() ;
	}
}
