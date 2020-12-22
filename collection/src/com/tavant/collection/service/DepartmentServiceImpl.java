package com.tavant.collection.service;

import java.util.List;
import java.util.Optional;

import com.tavant.collection.dao.*;
import com.tavant.collection.models.*;

public class DepartmentServiceImpl implements DepartmentService {
		
	private DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();
	private static DepartmentService departmentServiceImpl;
	
	public static DepartmentService getInstance() {
		if(departmentServiceImpl==null)
			synchronized (DepartmentServiceImpl.class) {
				if(departmentServiceImpl==null) {
					departmentServiceImpl = new DepartmentServiceImpl();
				}
			}
		return departmentServiceImpl;
	}
	private DepartmentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

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
