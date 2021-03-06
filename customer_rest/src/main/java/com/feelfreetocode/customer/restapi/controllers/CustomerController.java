package com.feelfreetocode.customer.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.customer.restapi.models.Customer;
import com.feelfreetocode.customer.restapi.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody @Valid Customer employee) {
		return this.customerRepository.save(employee);
	}
	
	
	@GetMapping("/all")
	public java.util.List<Customer> getCustomers(){
		return this.customerRepository.findAll();
	}
}
