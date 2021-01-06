package com.feelfreetocode.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine {
	
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private String image;

}
