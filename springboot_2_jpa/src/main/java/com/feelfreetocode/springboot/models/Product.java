package com.feelfreetocode.springboot.models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private Short quantityInStock;
	private BigDecimal buyPrice;
	private BigDecimal MSRP; 
	

	@ToString.Exclude
	@OneToMany(mappedBy = "product" , fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails;

}
