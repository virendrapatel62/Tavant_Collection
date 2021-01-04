package com.feelfreetocode.springboot.models;

import com.feelfreetocode.springboot.exceptions.InvalidDepartmentIdException;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Getter
	private String departmentId;
	
	@Setter @Getter
	private String departmentName;

	public void setDepartmentId(String departmentId)throws InvalidDepartmentIdException{
		if(departmentId== null || departmentId.trim().isEmpty())
			throw new InvalidDepartmentIdException("Department Id Must have atleast 1 Character");
		this.departmentId = departmentId;
	}
	
	
	
}
