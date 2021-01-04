package com.tavant.collection;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.tavant.collection.service.DepartmentService;
import com.tavant.collection.service.DepartmentServiceImpl;
import com.tavant.collection.service.EmployeeService;
import com.tavant.collection.service.EmployeeServiceImpl;
import com.tavant.collection.service.LocationService;
import com.tavant.collection.service.LocationServiceImpl;

public class ServiceFactory {

	final static List<String> classes = new ArrayList<String>();

//	parameter - list of string
	public static List<Object> getService(List<String> serviceTypes, boolean lazy) {
		List<Object> services = new ArrayList<Object>();
		if (lazy) {

			serviceTypes.forEach(serviceType -> {
				classes.forEach(className -> {
					if (className.toLowerCase().contains(serviceType.toLowerCase())) {

						Method getInstace;
						try {
							Class type = Class.forName(className);
							getInstace = type.getMethod("getInstance");
							Object instance = getInstace.invoke(type);
							services.add(instance);
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}

					}
				});

			});

		} else {
//			initialize all objects
			EmployeeService employeeService = EmployeeServiceImpl.getInstance();
			DepartmentService departmentService = DepartmentServiceImpl.getInstance();
			LocationService locationService = LocationServiceImpl.getInstance();
			services.add(employeeService);
			services.add(locationService);
			services.add(departmentService);

		}
		return services;
	}

	static {
		File file = new File("./");
		File[] files = file.listFiles();

		FileFilter fileFilter = (fileName) -> {
			return fileName.getName().endsWith(".java") || fileName.isDirectory();

		};

		Consumer<File> consumer = new Consumer<File>() {

			@Override
			public void accept(File dir) {
				if (dir.isDirectory()) {
					File[] files = dir.listFiles(fileFilter);
					for (File object : files) {
						accept(object);
					}
				} else {
					classes.add(dir.getAbsolutePath().substring(dir.getAbsolutePath().indexOf("src") + 4)
							.replace("\\", ".").replace(".java", ""));
				}
			}
		};

		consumer.accept(file);
	}
}
