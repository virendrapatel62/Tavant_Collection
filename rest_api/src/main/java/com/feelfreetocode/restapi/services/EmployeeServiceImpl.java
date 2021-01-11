package com.feelfreetocode.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.restapi.models.Employee;
import com.feelfreetocode.restapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.findAll();
	}

}
