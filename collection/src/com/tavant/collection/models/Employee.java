package com.tavant.collection.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Comparable<Employee> {

	private String firstName;
	private String lastName;
	private String extention;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
