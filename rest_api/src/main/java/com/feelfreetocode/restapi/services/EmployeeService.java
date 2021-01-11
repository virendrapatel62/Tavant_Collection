package com.feelfreetocode.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feelfreetocode.restapi.models.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmployees();
}
