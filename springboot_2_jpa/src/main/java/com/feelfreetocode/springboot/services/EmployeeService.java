package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);

	public Optional<Employee> updateEmployee(Integer empId, Employee employee)
			throws InvalidSalaryException, InvalidNameException;

	public Optional<List<Employee>> getEmployees();

	public Optional<Employee> deleteEmploye(Integer empid);

	public Optional<Employee> getEmployeeById(Integer empid);

	public boolean isExists(Integer empId);

	public Employee getTopEmployeeOrderByJobTitleDesc();

	public Employee getTopEmployeeOrderByJobTitleAsc();

	public Optional<List<Employee>> getTop3EmployeeOrderByJobTitleAsc();

	public Optional<List<Employee>> getTop3EmployeeOrderByJobTitleDesc();

	public Optional<List<Employee>> getEmployeesByOfficeCode(String officeCode);
}
