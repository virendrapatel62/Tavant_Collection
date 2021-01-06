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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> updateDepartment(String departmentId, Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteDepartment(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> getDepartmentById(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExists(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
