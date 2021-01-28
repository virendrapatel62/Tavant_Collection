package com.feelfreetocode.product.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.product.restapi.models.Product;
import com.feelfreetocode.product.restapi.repository.ProductLineRepository;
import com.feelfreetocode.product.restapi.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/test")
	public String test() {
		return "PRODUCT API IS WORKING";
	}
	
	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody @Valid Product product) {
		return this.productRepository.save(product);
	}
	
	
	@GetMapping("/all")
	public java.util.List<Product> getProducts(){
		return this.productRepository.findAll();
	}
}
