package com.tavant.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class Company {

	private Employee employee;

//	@Autowired
//	public Company(@Qualifier("employee1") Employee employee) {
//		this.employee = employee;
//	}

	public Company() {
		System.out.println("Company.Company()");
	}

	public void init() {
		System.out.println("Company.init()");
	}

	public void destroy() {
		System.out.println("Company.destroy()");
	}

	@Override
	public String toString() {
		return this.hashCode() + " Company [employee=" + employee.hashCode() + "]";
	}

}
