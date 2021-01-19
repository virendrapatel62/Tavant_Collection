package com.feelfreetocode.customer.restapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "OrderDetail")
@Table(name = "orderDetails")
public class OrderDetail implements Serializable {

	@Id
	private Integer orderNumber;
	
	private String productNumber;

	private Integer quantityOrdered;
	private Double priceEach;
	private Short orderLineNumber;

}
