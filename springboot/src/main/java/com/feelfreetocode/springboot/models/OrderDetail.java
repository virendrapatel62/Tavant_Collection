package com.feelfreetocode.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

	private Order order;
	private Product product;
	private Integer quantityOrdered;
	private Double priceEach;
	private Integer orderLineNumber;
	

	

}
