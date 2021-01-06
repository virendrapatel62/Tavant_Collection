package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.feelfreetocode.springboot.exceptions.InvalidDepartmentIdException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
	
	@Getter @Id
	private String departmentId;
	
	@Setter @Getter
	private String departmentName;

	public void setDepartmentId(String departmentId)throws InvalidDepartmentIdException{
		if(departmentId== null || departmentId.trim().isEmpty())
			throw new InvalidDepartmentIdException("Department Id Must have atleast 1 Character");
		this.departmentId = departmentId;
	}
	
	
	
}
