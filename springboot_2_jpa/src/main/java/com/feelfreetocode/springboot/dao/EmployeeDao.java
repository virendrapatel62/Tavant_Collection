package com.feelfreetocode.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Department;
import com.feelfreetocode.springboot.models.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
}
