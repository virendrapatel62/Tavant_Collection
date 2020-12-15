package com.tavant.collection.dao;

import java.util.ArrayList;
import java.util.List;

import com.tavant.collection.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> employees = new ArrayList<Employee>(20);
	
	@Override
	public boolean addEmployee(Employee emp) {
		return this.employees.add(emp);
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		
		 if(employee == null ) {
			return employee;
		}
		
		Employee temp = this.getEmployeeById(empId);
		temp.setEmployeeFirstName(employee.getEmployeeFirstName());
		temp.setEmployeeLastName(employee.getEmployeeLastName());
		temp.setEmployeeMobileNumber(employee.getEmployeeMobileNumber());
		temp.setEmployeeFirstName(employee.getEmployeeFirstName());
		temp.setEmployeeSalary(employee.getEmployeeSalary());
		return temp;
	}
	
	@Override
	public Employee getEmployeeById(String empid) {
		for (Employee employee : employees) {
			if(employee.getEmployeeId().equals(empid))
				return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return this.employees;
	}

	@Override
	public Employee deleteEmploye(String empid) {
		Employee employee = this.getEmployeeById(empid);
		this.employees.remove(employee);
		return employee;
	}

	@Override
	public boolean isExists(String empId) {
		return (this.getEmployeeById(empId) != null ) ? true : false ;
	}

}
