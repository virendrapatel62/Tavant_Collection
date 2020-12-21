package com.tavant.collection;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;
import com.tavant.collection.service.EmployeeService;
import com.tavant.collection.service.EmployeeServiceImpl;

public class MainOptional {

	public static void main(String[] args) {
		EmployeeService employeeService = EmployeeServiceImpl.getInstance();

		try {
			Employee employee = new Employee("ABC1", "Virendra", "Patel", "9155546734", 1200f);
			employeeService.addEmployee(employee);

			Optional<Employee> emOptional = employeeService.getEmployeeById("ABC1");

			if (emOptional.isPresent()) {
				System.out.println(emOptional.get());
			} else {
				System.err.println("Not FOund..");
			}
			
			
			Optional<List<Employee>> list = employeeService.getEmployees();
			System.out.println(list);

		} catch (InvalidNameException e) {

		} catch (InvalidSalaryException e) {
			// TODO: handle exception
		}
	}

}
