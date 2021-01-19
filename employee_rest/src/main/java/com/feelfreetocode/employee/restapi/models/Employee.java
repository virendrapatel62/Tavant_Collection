package com.feelfreetocode.employee.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Component
@Entity(name =  "Employee")
@Table(name = "employees")
public class Employee implements Comparable<Employee> {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id @Column(name = "employeeNumber")
	private Integer employeeId;
	
	@Column(length = 20 , name = "firstName") @Size(max = 20)
	@NotBlank(message = "First Name must not be blank")
	private String firstName;
	
	@Column(length = 20) @Size(max = 20)
	@NotBlank(message = "Last Name must not be blank")
	private String lastName;

	private String extension;
	
	

	@NotBlank(message = "email should not be blank")
	@Email(message = "provide valid email")
	private String email;
	
	
	private String officeCode;
	
	private Integer reportsTo;
	
	
	@Column(length = 20) 
	@Size(max = 25)
	private String jobTitle;
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}