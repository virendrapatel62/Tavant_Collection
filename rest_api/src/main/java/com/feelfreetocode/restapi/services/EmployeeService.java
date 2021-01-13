package com.feelfreetocode.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feelfreetocode.restapi.models.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Optional<Employee> getEmployeeById(Integer employeeId);
}
