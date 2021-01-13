package com.feelfreetocode.restapi.utils;

public class StringUtils {
	private static final String regex = "([a-z])([A-Z]+)";
	private static final String replacement = "$1_$2";

	public static String toCamelCase(String str) {

		return str != null ? str.toLowerCase().replaceAll(regex, replacement) : null;
	}

}
