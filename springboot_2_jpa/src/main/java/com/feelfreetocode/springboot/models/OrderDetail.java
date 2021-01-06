package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
	@Id
	private Integer orderDetailId;
	
	private Integer orderId;
	private String productCode;
	private Integer quantityOrdered;
	private Double priceEach;
	private Integer orderLineNumber;
	

	

}
