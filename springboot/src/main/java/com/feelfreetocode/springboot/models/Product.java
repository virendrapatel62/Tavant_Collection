package com.feelfreetocode.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
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
