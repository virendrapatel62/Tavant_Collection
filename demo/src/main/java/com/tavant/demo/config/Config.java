package com.tavant.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.tavant.demo.model.Company;
import com.tavant.demo.model.Employee;

@Configuration
@ComponentScan("com.tavant.demo")
@Import(DBConfig.class)
public class Config {

	
	@Lazy(true)
	@Bean("employee1")
	public Employee getEmployeeObject() {
		System.out.println("----Config.getEmployeeObject()----");
		return new Employee();
	}
	
	@Lazy(false)
	@Bean(name = "company")
	public Company getCompanyObject() {
		System.out.println("---Config.getCompanyObject()----");
		return new Company();
	}

}
