package com.feelfreetocode.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.springboot.dao.DepartmentDao;
import com.feelfreetocode.springboot.models.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Boolean addDepartment(Department department) {
		return this.departmentDao.addDepartment(department);
	}

	@Override
	public Optional<Department> updateDepartment(String departmentId, Department department) {
		return departmentDao.updateDepartment(departmentId, department);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		return this.departmentDao.getDepartments();
	}

	@Override
	public Boolean deleteDepartment(String departmentId) {
		return this.departmentDao.deleteDepartment(departmentId);

	}

	@Override
	public Optional<Department> getDepartmentById(String departmentId) {
		return this.departmentDao.getDepartmentById(departmentId);
	}

	@Override
	public Boolean isExists(String departmentId) {
		return this.departmentDao.isExists(departmentId);
	}

}
