package com.feelfreetocode.springboot;

import java.sql.SQLException;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.services.EmployeeServiceImpl;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws BeansException, SQLException {

		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
//		System.out.println(context.getBean(DBUtils.class).getConnection());

		
			Employee employee = new Employee();
			employee.setEmail("patelvirendra62@gmail.com");
			employee.setFirstName("Virendra Kumar");
			employee.setLastName("Patel");
			employee.setJobTitle("Software Eng.. traineee");
			employee.setExtention("A");
			employee.setOfficeCode("1");
			employee.setReportsTo(1002);
			employee.setEmployeeId(1771);

			employee = context.getBean(EmployeeServiceImpl.class).addEmployee(employee);

			
		
		System.out.println("SpringbootApplication.main()-- JPA");

	}

}
