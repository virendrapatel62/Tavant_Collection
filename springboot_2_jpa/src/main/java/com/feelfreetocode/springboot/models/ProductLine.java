package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductLine {
	@Id
	private Integer productLineId;
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private String image;

}
