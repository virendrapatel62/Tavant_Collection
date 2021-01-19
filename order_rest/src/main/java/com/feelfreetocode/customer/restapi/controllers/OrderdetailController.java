package com.feelfreetocode.customer.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.customer.restapi.models.OrderDetail;
import com.feelfreetocode.customer.restapi.repository.OrderDetailRepository;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderdetailController {
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@PostMapping()
	public OrderDetail createEmployee(@RequestBody @Valid OrderDetail orderDetail) {
		return this.orderDetailRepository.save(orderDetail);
	}
	
	
	@GetMapping()
	public java.util.List<OrderDetail> getCustomers(){
		return this.orderDetailRepository.findAll();
	}
}
