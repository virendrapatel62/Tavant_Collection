package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private Double buyPrice;
	private String productDescription;
	private Integer quantityInStock;
	private Double MSRP;

}
