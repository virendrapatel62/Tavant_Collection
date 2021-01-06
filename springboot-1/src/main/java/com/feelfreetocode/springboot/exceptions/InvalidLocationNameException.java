package com.feelfreetocode.springboot.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidLocationNameException extends Exception {

	
	private static final long serialVersionUID = -219356170004799569L;

	public InvalidLocationNameException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() ;
	}
}
