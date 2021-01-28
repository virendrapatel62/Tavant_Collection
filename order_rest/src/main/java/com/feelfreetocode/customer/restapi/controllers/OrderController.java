package com.feelfreetocode.customer.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.customer.restapi.models.Order;
import com.feelfreetocode.customer.restapi.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/test")
	public String test() {
		return "ORDER API IS WORKING";
	}
	
	@PostMapping("/createOrder")
	public Order createorder(@RequestBody @Valid Order order) {
		return this.orderRepository.save(order);
	}
	
	
	@GetMapping("/all")
	public java.util.List<Order> getOrders(){
		return this.orderRepository.findAll();
	}
}
