package com.feelfreetocode.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order{
	private java.util.Date orderDate;
	private java.util.Date requiredDate;
	private java.util.Date shippedDate;
	private String status;
	private Customer customer;

}