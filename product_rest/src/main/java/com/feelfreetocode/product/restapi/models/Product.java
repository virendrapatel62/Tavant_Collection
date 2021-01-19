package com.feelfreetocode.product.restapi.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
	
	@Id
	private String productCode;
	
//	@NotBlank()
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private Short quantityInStock;
	private BigDecimal buyPrice;
	private BigDecimal MSRP; 
	


}
