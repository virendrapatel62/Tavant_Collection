package com.feelfreetocode.springboot;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.feelfreetocode.springboot.dao.EmployeeDao;
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
//		getAll();
		
		 EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
		 EmployeeDao dao = context.getBean(EmployeeDao.class);
//		System.out.println(employeeService.getTopEmployeeOrderByJobTitleAsc());
//		 System.out.println(employeeService.getTopEmployeeOrderByJobTitleDesc());
		 
//		 employeeService.getEmployeesByOfficeCode("1")
//		 .get().forEach(System.out::println);
		 
//		 employeeService.getTop3EmployeeOrderByJobTitleAsc().get().forEach(System.out::println);
//		 System.out.println("-----");
//		 employeeService.getTop3EmployeeOrderByJobTitleDesc().get().forEach(System.out::println);
		 
//		 dao.findByOfficeCode("1").get().forEach(System.out::println);
		 System.out.println("---");
//		 dao.findFirst2ByOfficeCode("1").get().forEach(System.out::println);
		 System.out.println("---");
//		 dao.findTop2ByOfficeCode("1").get().forEach(System.out::println);
		 System.out.println("---");
		 
//		 dao.findByFirstNameLike("Diane").get().forEach(System.out::println);
		 System.out.println("---"); 
//		 dao.findByOfficeCodeGreaterThanEqual("5").get().forEach(e->System.out.println(e.getOfficeCode()));
		 System.out.println("---"); 
		 
		 System.out.println(dao.countByOfficeCode("7"));
		 System.out.println(dao.countByOfficeCode());
	
		 	dao.getOfficeCodeWithCount()
		 	.forEach(e->{
		 		System.out.println(e.getCode() + "--> " + e.getCount());
		 	});
		 
		 	
		 	
		 

	}
	private static void insertRandomData(int count) {
		IntStream.range(1, count).forEach(e -> {
			Employee employee = new Employee();
			employee.setEmail("Virendra"+e+"@gmail.com");
			employee.setFirstName("Name " + e);
			employee.setLastName("ln" + e);
			employee.setJobTitle("Software Eng.. traineee") ;
			employee.setExtension("A"+e); 
			employee.setOfficeCode(""+e);
//			employee.setReportsTo(e); 
			employee.setEmployeeId(Math.abs((int)new Date().getTime()));
			try {
				employee = context.getBean(EmployeeServiceImpl.class).addEmployee(employee);
				System.out.println(employee);
			}catch (Exception ee) {
				// TODO: handle exception
				ee.printStackTrace();
			}
		});  

	}
	
	private static void getAll() {
		context.getBean(EmployeeServiceImpl.class)
		.getEmployees()
		.get()
		.forEach(System.out::println);
	}

}
