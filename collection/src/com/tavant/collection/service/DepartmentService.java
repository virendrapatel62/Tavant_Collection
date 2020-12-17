package com.tavant.collection.service;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.models.Department;

public interface DepartmentService {
	public Boolean addDepartment(Department department);
	public Optional<Department> updateDepartment(String departmentId , Department department);
	public Optional<List<Department>> getDepartments();
	public Boolean deleteDepartment(String departmentId);
	public Optional<Department> getDepartmentById(String departmentId);
	public Boolean isExists(String departmentId);
}
