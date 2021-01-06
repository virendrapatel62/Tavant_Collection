package com.feelfreetocode.springboot.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 3686215097603783181L;

	public InvalidNameException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() ;
	}
}
