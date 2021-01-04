package com.feelfreetocode.springboot.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DBUtils {
	
	@Autowired
	private Environment environment;

	public DataSource getDataSource() {
		System.out.println("DBUtils.getDataSource()");
		BasicDataSource dataSource = new BasicDataSource();
		String url = environment.getProperty("db.url");
		dataSource.setUrl(url);
		return dataSource;
	}

	public void closeConnection(Connection connection) {
		System.out.println("DBUtils.closeConnection()");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		System.out.println("DBUtils.getConnection()");
		Connection connection = null;
		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
