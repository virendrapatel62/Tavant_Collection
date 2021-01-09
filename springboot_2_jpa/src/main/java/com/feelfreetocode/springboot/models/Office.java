package com.feelfreetocode.springboot.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity(name = "Office")
@Table(name = "offices")
public class Office {

	@Id
	private String officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "officeCode" , fetch = FetchType.LAZY)
	private List<Employee> employees;

	
	

}
