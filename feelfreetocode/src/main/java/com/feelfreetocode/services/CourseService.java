package com.feelfreetocode.services;

import org.springframework.stereotype.Service;

import com.feelfreetocode.models.Course;

@Service
public interface CourseService {
	public Course saveCourse(Course course);
}
