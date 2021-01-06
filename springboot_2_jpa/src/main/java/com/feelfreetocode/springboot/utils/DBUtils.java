package com.feelfreetocode.springboot.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Component
//@PropertySource("classpath:application.properties")
//@Configuration
public class DBUtils {
//
//	@Autowired
//	private Environment environment;
//
//	@Bean 
//	@ConfigurationProperties("spring.datasource") 
//	public DataSource getDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	public void closeConnection(Connection connection) {
//		System.out.println("DBUtils.closeConnection()");
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public Connection getConnection() {
//		System.out.println("DBUtils.getConnection()");
//		Connection connection = null;
//		try {
//			connection = getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
}
