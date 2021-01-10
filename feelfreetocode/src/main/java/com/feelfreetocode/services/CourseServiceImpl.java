package com.feelfreetocode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.dao.CourseDao;
import com.feelfreetocode.models.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	public CourseServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Course saveCourse(Course course) {
		return courseDao.save(course);
	}

}
