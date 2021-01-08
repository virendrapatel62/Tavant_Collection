package com.feelfreetocode.springboot.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class TavantPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {
	public static final String CAMEL_CASE_REGEX = "([a-z]+)([A-Z]+)";

	public static final String SNAKE_CASE_PATTERN = "$1\\_$2";

	public TavantPhysicalNamingStrategy() {
		// TODO Auto-generated constructor stub
		System.out.println("TavantPhysicalNamingStrategy.TavantPhysicalNamingStrategy()");
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {

//		return super.toPhysicalColumnName(formatIdentifier(name.getText()), context);
		return super.toPhysicalColumnName(name, context);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		System.out.println("-------" + name + "-------");
		return Identifier.toIdentifier(name.getText());
	}

	private Identifier formatIdentifier(String name) {
		String id = name.replaceAll(CAMEL_CASE_REGEX, SNAKE_CASE_PATTERN).toLowerCase();
		return Identifier.toIdentifier(id);
	}

}
