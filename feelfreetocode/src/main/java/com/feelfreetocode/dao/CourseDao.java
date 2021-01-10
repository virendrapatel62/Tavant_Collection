package com.feelfreetocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.models.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
}
