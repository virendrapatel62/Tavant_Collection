package com.feelfreetocode.springboot.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDepartmentIdException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public InvalidDepartmentIdException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		return super.toString() ;
	}
}
