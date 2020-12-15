package com.tavant.collection.dao;

import java.util.List;

import com.tavant.collection.models.Department;
import com.tavant.collection.models.Employee;

public interface DepartmentDao {
	public Boolean addDepartment(Department department);
	public Department updateDepartment(String departmentId , Department department);
	public List<Department> getDepartments();
	public Boolean deleteDepartment(String departmentId);
	public Department getDepartmentById(String departmentId);
	public Boolean isExists(String departmentId);
}
