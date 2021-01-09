package com.feelfreetocode.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.springboot.models.EmployeeModel;


@Repository
public interface EmployeeModelDao extends JpaRepository<EmployeeModel, Long> {
	public Page<EmployeeModel> findByDepartment(String department , Pageable pageable);
}
