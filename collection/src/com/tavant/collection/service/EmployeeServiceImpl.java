package com.tavant.collection.service;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.dao.EmployeeDao;
import com.tavant.collection.dao.EmployeeDaoImpl;
import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {
		
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public boolean addEmployee(Employee emp) {
		return this.employeeDao.addEmployee(emp);
	}

	@Override
	public Optional<Employee> updateEmployee(String empId, Employee employee) throws InvalidNameException,  InvalidSalaryException {
		return this.employeeDao.updateEmployee(empId, employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		
		return this.employeeDao.getEmployees();
	}

	@Override
	public Optional<Employee> deleteEmploye(String empid) {
		return this.employeeDao.deleteEmploye(empid);
	}

	@Override
	public Optional<Employee> getEmployeeById(String empid) {
		return this.employeeDao.getEmployeeById(empid);
	}

	@Override
	public boolean isExists(String empId) {
		return this.employeeDao.isExists(empId);
	}

}
