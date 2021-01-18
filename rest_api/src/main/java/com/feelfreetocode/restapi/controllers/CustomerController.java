package com.feelfreetocode.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.restapi.models.Office;
import com.feelfreetocode.restapi.models.Product;
import com.feelfreetocode.restapi.repository.OfficeRepository;

@RestController
@RequestMapping("/api/offices")
public class CustomerController {

	
	@Autowired
	private OfficeRepository officeRepository;


	@PostMapping()
	public Office createOffice(@RequestBody @Valid Office office) {
		return this.officeRepository.save(office);
	}

}
