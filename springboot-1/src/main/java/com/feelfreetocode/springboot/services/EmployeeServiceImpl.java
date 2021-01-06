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
	
	private EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return this.employeeDaoImpl.addEmployee(emp);
	}

	@Override
	public Optional<Employee> updateEmployee(Integer empId, Employee employee)
			throws InvalidNameException, InvalidSalaryException {
		return this.employeeDaoImpl.updateEmployee(empId, employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {

		return this.employeeDaoImpl.getEmployees();
	}

	@Override
	public Optional<Employee> deleteEmploye(Integer empid) {
		return this.employeeDaoImpl.deleteEmploye(empid);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer empid) {
		return this.employeeDaoImpl.getEmployeeById(empid);
	}

	@Override
	public boolean isExists(Integer empId) {
		return this.employeeDaoImpl.isExists(empId);
	}

}
