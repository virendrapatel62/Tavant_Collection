package com.feelfreetocode.employee.restapi.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.employee.restapi.models.Employee;
import com.feelfreetocode.employee.restapi.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository  employeeRepository;
	
	@PostMapping()
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	
	@GetMapping()
	public java.util.List<Employee> getEmployees(){
		return this.employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id){
		Optional<Employee> optional= this.employeeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id){
		this.employeeRepository.deleteById(id);
		
	}
}
