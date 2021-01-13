package com.feelfreetocode.restapi.controllers;

import java.util.List;

import javax.persistence.RollbackException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.restapi.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.restapi.exceptions.ValidationException;
import com.feelfreetocode.restapi.models.Employee;
import com.feelfreetocode.restapi.repository.EmployeeRepository;
import com.feelfreetocode.restapi.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping()
	public List<Employee> getEmployees() {
		return this.employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity getEmployeeById(@PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok(this.employeeService.getEmployeeById(id).get());
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee With Id " + id + " not found");
		}
	}

	@PostMapping()
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
		System.out.println("EmployeeController.createEmployee()");
		System.out.println(employee);

		return this.employeeRepository.save(employee);

	}

}
