package com.tavant.collection.dao;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;

public interface EmployeeDao {
	public boolean addEmployee(Employee emp);
	public Optional<Employee> updateEmployee(String empId , Employee employee)throws InvalidSalaryException , InvalidNameException;
	public Optional<List<Employee>> getEmployees();
	public Optional<Employee> deleteEmploye(String empid);
	public Optional<Employee> getEmployeeById(String empid);
	public boolean isExists(String empId);
}
