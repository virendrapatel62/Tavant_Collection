package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import com.feelfreetocode.springboot.models.Department;

public interface DepartmentService {
	public Boolean addDepartment(Department department);
	public Optional<Department> updateDepartment(String departmentId , Department department);
	public Optional<List<Department>> getDepartments();
	public Boolean deleteDepartment(String departmentId);
	public Optional<Department> getDepartmentById(String departmentId);
	public Boolean isExists(String departmentId);
}
