package com.feelfreetocode.employee.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.employee.restapi.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
