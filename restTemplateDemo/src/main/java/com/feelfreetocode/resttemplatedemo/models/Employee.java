package com.feelfreetocode.resttemplatedemo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

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

	private String extension;

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