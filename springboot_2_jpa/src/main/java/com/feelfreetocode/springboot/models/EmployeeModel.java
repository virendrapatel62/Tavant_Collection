package com.feelfreetocode.springboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "EmployeeModel")
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	private String name;
	private String department;
	private Integer salary;

	public EmployeeModel(String name, String department, Integer salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

}
