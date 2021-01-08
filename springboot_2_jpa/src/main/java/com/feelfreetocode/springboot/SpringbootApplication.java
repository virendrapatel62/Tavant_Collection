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
import com.feelfreetocode.springboot.dao.OfficeDao;
import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.models.Office;
import com.feelfreetocode.springboot.services.EmployeeServiceImpl;

@SpringBootApplication
public class SpringbootApplication {
	private static ApplicationContext context;
	public static void main(String[] args) throws BeansException, SQLException {

		context = SpringApplication.run(SpringbootApplication.class, args);
		EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
		 EmployeeDao dao = context.getBean(EmployeeDao.class);
		 	
		 	OfficeDao dao2 = context.getBean(OfficeDao.class);
		 	Office office = new Office("of1" , "Jabalpur" , "123456789" , "AVC" ,
		 			"A" ,  "B" , "C" , "D" , "E" , null );
//		 	dao2.save(of);
		 	
		 	Employee employee = new Employee();
			employee.setEmail("Virendra@gmail.com");
			employee.setFirstName("Name ");
			employee.setLastName("ln");
			employee.setJobTitle("Software Eng.. traineee") ;
			employee.setExtension("A"); 
			employee.setOfficeCode(office);
//			employee.setReportsTo(); 
			employee.setEmployeeId(Math.abs((int)new Date().getTime()));
			try {
				employee = context.getBean(EmployeeServiceImpl.class).addEmployee(employee);
				System.out.println(employee);
			}catch (Exception ee) {
				// TODO: handle exception
				ee.printStackTrace();
			}
//		 	
		 	
		 	
		 

	}
	private static void insertRandomData(int count) {
		IntStream.range(1, count).forEach(e -> {
			Employee employee = new Employee();
			employee.setEmail("Virendra"+e+"@gmail.com");
			employee.setFirstName("Name " + e);
			employee.setLastName("ln" + e);
			employee.setJobTitle("Software Eng.. traineee") ;
			employee.setExtension("A"+e); 
//			employee.setOfficeCode(""+e);
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
