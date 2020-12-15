package com.tavant.collection.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidSalaryException extends Exception {

	public InvalidSalaryException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + getMessage();
	}
}
