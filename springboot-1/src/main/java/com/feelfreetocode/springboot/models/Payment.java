package com.feelfreetocode.springboot.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private Customer customer;
	private String checkNumber;
	private Date paymentDate;
	private double amount;

}
