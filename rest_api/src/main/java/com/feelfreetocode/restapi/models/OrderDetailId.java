package com.feelfreetocode.restapi.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailId implements Serializable {
	
	private Order order;

	private Product product;

}
