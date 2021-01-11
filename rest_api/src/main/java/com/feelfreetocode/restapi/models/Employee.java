package com.feelfreetocode.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Entity(name =  "Employee")
@Table(name = "employees")
public class Employee implements Comparable<Employee> {
	
	
	@Id @Column(name = "employeeNumber")
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
