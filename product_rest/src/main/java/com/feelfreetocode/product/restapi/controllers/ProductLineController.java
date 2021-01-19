package com.feelfreetocode.product.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.product.restapi.models.ProductLine;
import com.feelfreetocode.product.restapi.repository.ProductLineRepository;

@RestController
@RequestMapping("/api/productlines")
public class ProductLineController {
	
	@Autowired
	private ProductLineRepository productLineRepository;
	
	@PostMapping()
	public ProductLine createEmployee(@RequestBody @Valid ProductLine productLine) {
		return this.productLineRepository.save(productLine);
	}
	
	
	@GetMapping()
	public java.util.List<ProductLine> getCustomers(){
		return this.productLineRepository.findAll();
	}
}
