package com.feelfreetocode.restapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "OrderDetail")
@Table(name = "orderDetails")
@IdClass(OrderDetailId.class)
public class OrderDetail implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "productNumber")
	private Product product;

	private Integer quantityOrdered;
	private Double priceEach;
	private Short orderLineNumber;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class OrderDetailId implements Serializable {
	
	private Order order;

	private Product product;

}
