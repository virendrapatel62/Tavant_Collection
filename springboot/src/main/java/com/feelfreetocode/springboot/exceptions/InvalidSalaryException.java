package com.feelfreetocode.springboot.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidSalaryException extends Exception {

	
	private static final long serialVersionUID = 1409962974905278968L;

	public InvalidSalaryException(String message) {
		super(message);
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() ;
	}
}
