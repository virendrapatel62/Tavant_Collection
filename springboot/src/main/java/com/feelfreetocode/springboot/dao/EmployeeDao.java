package com.feelfreetocode.springboot.dao;

import java.util.List;
import java.util.Optional;

import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Employee;

public interface EmployeeDao {
	public boolean addEmployee(Employee emp);
	public Optional<Employee> updateEmployee(Integer empId , Employee employee)throws InvalidSalaryException , InvalidNameException;
	public Optional<List<Employee>> getEmployees();
	public Optional<Employee> deleteEmploye(Integer empid);
	public Optional<Employee> getEmployeeById(Integer empid);
	public boolean isExists(Integer empId);
}
