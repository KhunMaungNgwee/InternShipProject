package com.apple.internship.service;

import java.util.List;
import java.util.Optional;

import com.apple.internship.entity.Course;


public interface CourseService {
public List<Course> getAll();
	
	public Optional<Course>  getCourseById(Long courseId);
	
	public Course create(Course course);
	
	public void delete(Long courseId);
}
