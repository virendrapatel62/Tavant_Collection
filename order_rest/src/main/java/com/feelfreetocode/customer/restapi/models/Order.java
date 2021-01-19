package com.feelfreetocode.customer.restapi.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Order")
@Table(name = "orders")
public class Order {

	@Id
	private Integer orderNumber;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String status;
	private String comments;
	
	private Integer customerNumber;
	
}
