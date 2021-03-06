package com.feelfreetocode.restapi.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Payment")
@Table(name="payments")
//@IdClass(PaymentId.class)
public class Payment implements Serializable {
	
	
	@Id
	private BigInteger paymentId;
	
	@ManyToOne
	@JoinColumn(name = "customerNumber")
	private Customer customer;
	private String checkNumber;
	private Date paymentDate;
	private Double amount;

}
