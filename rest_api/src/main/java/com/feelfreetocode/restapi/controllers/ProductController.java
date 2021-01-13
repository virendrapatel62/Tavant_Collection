package com.feelfreetocode.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.restapi.models.Employee;
import com.feelfreetocode.restapi.models.Product;
import com.feelfreetocode.restapi.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;


	@PostMapping()
	public Product createProduct(@RequestBody @Valid Product product) {
		System.out.println("ProductController.createProduct()");
		System.err.println(product.getProductCode());
		return this.productRepository.save(product);

	}

}
