package com.feelfreetocode.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Comparable<Employee> {
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String extention;
	private String email;
	private String officeCode;
	private Integer reportsTo;
	private String jobTitle;
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
