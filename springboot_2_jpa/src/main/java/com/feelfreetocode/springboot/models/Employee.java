package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Entity
public class Employee implements Comparable<Employee> {
	
	
	@Id
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
