package com.feelfreetocode.springboot;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.services.EmployeeServiceImpl;

@SpringBootApplication
public class SpringbootApplication {
	private static ApplicationContext context;
	public static void main(String[] args) throws BeansException, SQLException {

		 context = SpringApplication.run(SpringbootApplication.class, args);
//		System.out.println(context.getBean(DBUtils.class).getConnection());
		System.out.println("SpringbootApplication.main()-- JPA");
//		insertRandomData(5);
		getAll();

	}
	private static void insertRandomData(int count) {
		IntStream.range(1, count).forEach(e -> {
			Employee employee = new Employee();
			employee.setEmail("Virendra"+e+"@gmail.com");
			employee.setFirstName("Name " + e);
			employee.setLastName("ln" + e);
			employee.setJobTitle("Software Eng.. traineee");
			employee.setExtention("A"+e); 
			employee.setOfficeCode(""+e);
//			employee.setReportsTo(e);
			employee.setEmployeeId(Math.abs((int)new Date().getTime()));
			employee = context.getBean(EmployeeServiceImpl.class).addEmployee(employee);
		});  

	}
	
	private static void getAll() {
		context.getBean(EmployeeServiceImpl.class)
		.getEmployees()
		.get()
		.forEach(System.out::println);
	}

}
