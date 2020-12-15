package com.tavant.collection.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidLocationNameException extends Exception {

	public InvalidLocationNameException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + getMessage();
	}
}
