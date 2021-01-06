package com.feelfreetocode.springboot.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Orders")
public class Order{
	@Id
	private Integer orderId;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String customerId;

}