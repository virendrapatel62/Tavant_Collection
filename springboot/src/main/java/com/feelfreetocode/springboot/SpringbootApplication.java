package com.feelfreetocode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.feelfreetocode.springboot.models.Employee;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		System.out.println(context.getBean(Employee.class));
	}

}
