package com.tavant.collection;

import java.util.List;

import com.tavant.collection.service.DepartmentService;
import com.tavant.collection.service.DepartmentServiceImpl;
import com.tavant.collection.service.EmployeeService;
import com.tavant.collection.service.EmployeeServiceImpl;
import com.tavant.collection.service.LocationService;
import com.tavant.collection.service.LocationServiceImpl;

public class ServiceFactory {

//	parameter - list of string
	public static Object getService(List<String> serviceTypes, boolean lazy) {

		if (lazy) {

//			traverse list and init objects
			serviceTypes.forEach(serviceType -> {
				if ("employeeServiceImpl".equalsIgnoreCase(serviceType)) {
				}
				if ("departmentServiceImpl".equalsIgnoreCase(serviceType)) {
				}
				if ("locationServiceImpl".equalsIgnoreCase(serviceType)) {
				}
			});

		} else {
//			initialize all objects
			EmployeeService employeeService = EmployeeServiceImpl.getInstance();
			DepartmentService departmentService = DepartmentServiceImpl.getInstance();
			LocationService locationService = LocationServiceImpl.getInstance();

		}
		return null;
	}
}
