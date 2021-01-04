package com.feelfreetocode.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Employee;

@Repository("employeeDaoImpl2")
public class EmployeeDaoImpl2 implements EmployeeDao {

	public EmployeeDaoImpl2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
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
