package com.feelfreetocode.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.springboot.models.CountData;
import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.models.Office;


@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	
	public Employee findTopByOrderByJobTitleDesc();
	public Employee findTopByOrderByJobTitleAsc();
	public Optional<List<Employee>> findTop3ByOrderByJobTitleAsc();
	public Optional<List<Employee>> findTop3ByOrderByJobTitleDesc();
	public Optional<List<Employee>> findByOfficeCode(Office Office);
	public Optional<List<Employee>> findFirst2ByOfficeCode(Office Office);
	public Optional<List<Employee>> findTop2ByOfficeCode(Office Office);
	public Optional<List<Employee>> findByOfficeCodeGreaterThanEqual(Office Office);
	public Optional<List<Employee>> findByOfficeCodeLessThanEqual(Office Office);
	public Optional<List<Employee>> findByFirstNameLike(String firstName);
	
	public Integer countByOfficeCode(Office officeCode);
	
	@Query("select count(officeCode) from Employee")
	public Integer countByOfficeCode();
	
	@Query("select officeCode as code,  count(officeCode) as count from Employee group by officeCode order by officeCode desc")
	public List<CountData> getOfficeCodeWithCount();
	
	@Query("select officeCode as code,  count(officeCode) as count from Employee e group by e.officeCode order by e.officeCode desc ")
	public List<CountData> getEmployees();
	
	
	public Page<Employee> findByOfficeCode(Office officeCode , Pageable pageable);
	
}
 





