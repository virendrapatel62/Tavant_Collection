package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.springboot.dao.EmployeeDao;
import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Employee;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	public EmployeeDao getEmployeeDaoImpl() {
		return employeeDaoImpl;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeDaoImpl.save(emp);
	}

	@Override
	public Optional<Employee> updateEmployee(Integer empId, Employee employee)
			throws InvalidSalaryException, InvalidNameException {
		// TODO Auto-generated method stub
		employee.setEmployeeId(empId);
		return Optional.of(this.employeeDaoImpl.save(employee));
		
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		return Optional.of(this.employeeDaoImpl.findAll());
	}

	@Override
	public Optional<Employee> deleteEmploye(Integer empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer empid) {
		// TODO Auto-generated method stub
		Employee employee = this.employeeDaoImpl.getOne(empid);
		if(employee!=null)
			this.employeeDaoImpl.deleteById(empid);
		return Optional.ofNullable(employee);
	}

	@Override
	public boolean isExists(Integer empId) {
		// TODO Auto-generated method stub
		return this.employeeDaoImpl.existsById(empId);
	}

	@Override
	public Employee getTopEmployeeOrderByJobTitleDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getTopEmployeeOrderByJobTitleAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getTop3EmployeeOrderByJobTitleAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getTop3EmployeeOrderByJobTitleDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getEmployeesByOfficeCode(String officeCode) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Employee getTopEmployeeOrderByJobTitleDesc() {
//		// TODO Auto-generated method stub
//		return this.employeeDaoImpl.findTopByOrderByJobTitleDesc();
//	}
//	@Override
//	public Employee getTopEmployeeOrderByJobTitleAsc() {
//		// TODO Auto-generated method stub
//		return this.employeeDaoImpl.findTopByOrderByJobTitleAsc();
//	}
//
//	@Override
//	public Optional<List<Employee>> getEmployeesByOfficeCode(String officeCode) {
//		// TODO Auto-generated method stub
//		return this.employeeDaoImpl.findByOfficeCode(officeCode);
//	}
//
//	@Override
//	public Optional<List<Employee>> getTop3EmployeeOrderByJobTitleAsc() {
//		return this.employeeDaoImpl.findTop3ByOrderByJobTitleAsc();
//	}
//
//	@Override
//	public Optional<List<Employee>> getTop3EmployeeOrderByJobTitleDesc() {
//		// TODO Auto-generated method stub
//		return this.employeeDaoImpl.findTop3ByOrderByJobTitleDesc();
//	}
	
	
}
