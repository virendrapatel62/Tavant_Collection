package com.tavant.demo.model;
  
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tavant.demo.config.Config;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
//		Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
		
//		System.out.println(context.getBean(Company.class));
//		System.out.println(context.getBean(Employee.class));
//		System.out.println(context.getBean(Employee.class));
//		System.out.println(context.getBean(Employee.class));
//		System.out.println(context.getBean(Employee.class));
		context.close();
	}

}
