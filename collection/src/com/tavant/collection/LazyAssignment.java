package com.tavant.collection;

import java.io.File;
import java.io.FileFilter;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LazyAssignment {

	public static void main(String[] args) {
		List<String> serviceTypes = Arrays.asList("employeeDao", "departmentServiceImpl");
		List services = ServiceFactory.getService(serviceTypes, true);
		services.forEach(System.out::println);
	}
}
