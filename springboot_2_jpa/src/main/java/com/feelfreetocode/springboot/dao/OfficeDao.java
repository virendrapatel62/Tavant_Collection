package com.feelfreetocode.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.models.Office;

public interface OfficeDao extends  JpaRepository<Office, String>  {

}
