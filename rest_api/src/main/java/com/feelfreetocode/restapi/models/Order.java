package com.feelfreetocode.restapi.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@ManyToOne()
	@JoinColumn(name = "customerNumber")
	private Customer customer;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "order" , fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails;

}
