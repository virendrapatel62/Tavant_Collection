package com.feelfreetocode.springboot.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
	@Id
	private Integer paymentId;
	private Integer customerId;
	private String checkNumber;
	private Date paymentDate;
	private double amount;

}
