package com.tavant.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tavant.demo.model.Employee;

@ComponentScan("com.tavant.demo")

public class DBConfig {
	
	@Bean("employee2")
	public Employee getEmployeeObject() {
		System.out.println("DBConfig.getEmployeeObject()-------");
		return new Employee();
	}
}
