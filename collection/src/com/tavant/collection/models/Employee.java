package com.tavant.collection.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee>{
	private String employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeMobileNumber;
	private Float employeeSalary;
	
	
	@Override
	public int compareTo(Employee o) {
		return this.employeeId.compareTo(o.employeeId);
	}
}
