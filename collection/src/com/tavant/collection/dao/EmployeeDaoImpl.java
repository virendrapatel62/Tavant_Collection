package com.tavant.collection.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.tavant.collection.exceptions.InvalidNameException;
import com.tavant.collection.exceptions.InvalidSalaryException;
import com.tavant.collection.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {


	private Comparator<Employee> employeeComparator = (o1, o2) -> o1.getEmployeeId().compareTo(o2.getEmployeeId());
	private Set<Employee> employees = new TreeSet<Employee>(employeeComparator);
	
	private static EmployeeDao EMPLOYEE_DAO ;
	
	
	
	private EmployeeDaoImpl() {
	}
	
	public static EmployeeDao getInstance() {
		if(EMPLOYEE_DAO == null ) {
			synchronized (EmployeeDaoImpl.class) {
				if(EMPLOYEE_DAO == null) {
					EMPLOYEE_DAO = new EmployeeDaoImpl();
				}
			}
		}
		
		return EMPLOYEE_DAO;
	}
	
	
	@Override
	public boolean addEmployee(Employee emp) {
		return this.employees.add(emp);
	}

	@Override
	public Optional<Employee> updateEmployee(String empId, Employee employee)
			throws InvalidSalaryException, InvalidNameException {

		if (employee == null) {
			return Optional.empty();
		}

		Employee temp = this.getEmployeeById(empId).get();
		temp.setEmployeeFirstName(employee.getEmployeeFirstName());
		temp.setEmployeeLastName(employee.getEmployeeLastName());
		temp.setEmployeeMobileNumber(employee.getEmployeeMobileNumber());
		temp.setEmployeeFirstName(employee.getEmployeeFirstName());
		temp.setEmployeeSalary(employee.getEmployeeSalary());
		return Optional.of(temp);
	}

	@Override
	public Optional<Employee> getEmployeeById(String empid) {
		
		return this.employees.stream()
				.filter(e->e.getEmployeeId().equals(empid))
				.findFirst();
		
//		for (Employee employee : employees) {
//			if (employee.getEmployeeId().equals(empid))
//				return Optional.of(employee);
//		}
//
//		return Optional.empty();

	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		
		return this.employees.isEmpty() ? Optional.empty() : Optional.of(new ArrayList<Employee>(this.employees));

	}

	@Override
	public Optional<Employee> deleteEmploye(String empid) {
		
		Employee employee = this.getEmployeeById(empid).get();
		
		this.employees = this.employees.stream()
		.filter(e->!(e.getEmployeeId().equals(empid)))
		.collect(Collectors.toSet());
		return Optional.ofNullable(employee);
	}

	@Override
	public boolean isExists(String empId) {
		return (this.getEmployeeById(empId) != null) ? true : false;
	}

}
