package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.springboot.dao.EmployeeDao;
import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Employee;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDaoImpl;

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeDaoImpl.save(emp);
	}

	@Override
	public Optional<Employee> updateEmployee(Integer empId, Employee employee)
			throws InvalidSalaryException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> deleteEmploye(Integer empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Integer empId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
