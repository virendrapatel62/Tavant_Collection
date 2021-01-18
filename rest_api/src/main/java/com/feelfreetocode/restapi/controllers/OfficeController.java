package com.feelfreetocode.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.restapi.models.Customer;
import com.feelfreetocode.restapi.models.Office;
import com.feelfreetocode.restapi.models.Product;
import com.feelfreetocode.restapi.repository.CustomerRepository;
import com.feelfreetocode.restapi.repository.OfficeRepository;

@RestController
@RequestMapping("/api/paymments")
public class OfficeController {

	
	@Autowired
	private CustomerRepository customerRepository;


	@PostMapping()
	public Customer createCustomer(@RequestBody @Valid Customer customer) {
		return this.customerRepository.save(customer);
	}

}
