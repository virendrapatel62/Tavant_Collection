package com.tavant.collection.dao;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.models.Department;

public interface DepartmentDao {
	public Boolean addDepartment(Department department);
	public Optional<Department> updateDepartment(String departmentId , Department department);
	public Optional<List<Department>> getDepartments();
	public Boolean deleteDepartment(String departmentId);
	public Optional<Department> getDepartmentById(String departmentId);
	public Boolean isExists(String departmentId);
}
