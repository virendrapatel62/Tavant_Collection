package com.feelfreetocode.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.feelfreetocode.springboot.models.Department;

@Repository

public class DepartmentDaoImpl implements DepartmentDao {
	private List<Department> departments = new ArrayList<Department>(20);

	@Override
	public Optional<Department> getDepartmentById(String departmentId) {
		for (Department department : departments) {
			if (department.getDepartmentId().equals(departmentId))
				return Optional.of(department);
		}
		return Optional.empty();
	}

	@Override
	public Boolean isExists(String departmentId) {
		return (this.getDepartmentById(departmentId) != null) ? true : false;
	}

	@Override
	public Boolean addDepartment(Department department) {
		return this.departments.add(department);
	}

	@Override
	public Optional<Department> updateDepartment(String departmentId, Department department) {
		Department tempdDepartment = this.getDepartmentById(departmentId).get();
		tempdDepartment.setDepartmentName(department.getDepartmentName());
		return Optional.of(tempdDepartment);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		return (this.departments.isEmpty()) ? Optional.empty() : Optional.of(this.departments);
	}

	@Override
	public Boolean deleteDepartment(String departmentId) {

		return this.departments.remove(this.getDepartmentById(departmentId).get());
	}

}
