package com.tavant.collection.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Employee implements Comparable<Employee> {

	@Setter
	@Getter
	private String employeeId;

	@Getter
	private String employeeFirstName;

	@Getter
	private String employeeLastName;

	@Setter
	@Getter
	private String employeeMobileNumber;

	@Getter
	private Float employeeSalary;

	@Override
	public int compareTo(Employee o) {
		return this.employeeId.compareTo(o.employeeId);
	}

	public void setEmployeeSalary(Float employeeSalary) throws InvalidSalaryException {
		if (employeeSalary < 0 || employeeSalary == null)
			throw new InvalidSalaryException("Salary cant be Nagative Value");
		this.employeeSalary = employeeSalary;
	}

	public Employee(String employeeId, String employeeFirstName, String employeeLastName, String employeeMobileNumber,
			Float employeeSalary) throws InvalidSalaryException, InvalidNameException {
		super();
		this.employeeId = employeeId;
		this.employeeMobileNumber = employeeMobileNumber;
		this.setEmployeeFirstName(employeeFirstName);
		this.setEmployeeLastName(employeeLastName);
		this.setEmployeeSalary(employeeSalary);
	}

	public void setEmployeeFirstName(String employeeFirstName) throws InvalidNameException {

		if (employeeFirstName == null)
			throw new NullPointerException("Name should not be null ");

		if (employeeFirstName.trim().isEmpty())
			throw new InvalidNameException("Employee First Name must contain 1 character long");

		Pattern pattern = java.util.regex.Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
		Matcher matcher = pattern.matcher(employeeFirstName);
		boolean matchFound = matcher.matches();

		if (!matchFound) {
			throw new InvalidNameException("Name must not contain number or special char");
		}

		this.employeeFirstName = employeeFirstName;
	}

	public void setEmployeeLastName(String employeeLastName) throws InvalidNameException {
		if (employeeLastName == null)
			throw new NullPointerException("Name should not be null ");

		if (employeeLastName.trim().isEmpty())
			throw new InvalidNameException("Employee Last Name must contain 1 character long");

		Pattern pattern = java.util.regex.Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
		Matcher matcher = pattern.matcher(employeeLastName);
		boolean matchFound = matcher.matches();

		if (!matchFound) {
			throw new InvalidNameException("Name must not contain number or special char");
		}

		this.employeeLastName = employeeLastName;
	}
}
