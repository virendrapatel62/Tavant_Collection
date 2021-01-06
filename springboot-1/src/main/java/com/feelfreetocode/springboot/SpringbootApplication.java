package com.feelfreetocode.springboot;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.feelfreetocode.springboot.dao.EmployeeDaoImpl;
import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.utils.DBUtils;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws BeansException, SQLException {

		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		System.out.println(context.getBean(DBUtils.class).getConnection());

//		context.getBean(EmployeeDaoImpl.class).getEmployees().get().forEach(System.out::println);
		// @formatter:on

	}

}
