package com.feelfreetocode.product.restapi.models;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productlines")
public class ProductLine {
	
	@Id
	private Integer productLineCode;
	private String productLine;
	private String productCode;
	private String textDescription;
	private String htmlDescription;
	private Blob image;

}
