package com.tavant.collection.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidNameException extends Exception {

	public InvalidNameException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + getMessage();
	}
}
