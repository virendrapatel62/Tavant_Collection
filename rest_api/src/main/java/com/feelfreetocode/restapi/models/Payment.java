package com.feelfreetocode.restapi.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Payment")
@Table(name="payments")
public class Payment implements Serializable {
	
	
	@Id
	@ManyToOne
	@JoinColumn(name = "customerNumber")
	private Customer customer;
	private String checkNumber;
	private Date paymentDate;
	private Double amount;

}
