package com.feelfreetocode.springboot.models;

import java.sql.Date;

public class Order {

	private Integer orderNumber;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	private Integer customerNumber;

}
