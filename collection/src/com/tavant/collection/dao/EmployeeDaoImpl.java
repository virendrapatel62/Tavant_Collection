package com.tavant.collection.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {  
	
	private Comparator<Employee> employeeComparator = (o1,o2)-> o1.getEmployeeId().compareTo(o2.getEmployeeId());
	private Set<Employee> employees = new TreeSet<Employee>(employeeComparator);
	
	@Override
	public boolean addEmployee(Employee emp) {
		return this.employees.add(emp);
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) throws InvalidSalaryException , InvalidNameException{
		
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
		return new ArrayList<Employee>(this.employees);
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
