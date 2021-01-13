package com.feelfreetocode.restapi.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Customer")
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	private Integer customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private Integer salesRepEmployeeNumber;
	private BigDecimal creditLimit;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY)
	private List<Payment> payments;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY)
	private List<Order> orders;
	
}
