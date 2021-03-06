package com.feelfreetocode.employee.restapi.errorresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiValidationError extends ApiSubError {

	private String object;
	private String field;
	private Object rejectedValue;
	private String message;

	public ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

}
