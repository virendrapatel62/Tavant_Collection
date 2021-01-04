package com.tavant.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Employee implements Comparable<Employee> {
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String extention;
	private String email;
	private String officeCode;
	private Integer reportsTo;
	private String jobTitle;
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}
	
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
