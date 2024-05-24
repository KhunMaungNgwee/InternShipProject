package com.apple.internship.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.apple.internship.entity.Course;
import com.apple.internship.repository.CourseRepository;
import com.apple.internship.service.CourseService;
import com.internship.demo.common.ActiveStatus;

public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return courseRepository.getAllByActiveStatus(ActiveStatus.ACTIVE);
	}

	@Override
	public Optional<Course>  getCourseById(Long courseId){
		// TODO Auto-generated method stub
		return courseRepository.findById(courseId);
	}

	@Override
	public Course create(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public void delete(Long courseId) {
		// TODO Auto-generated method stub
		Optional<Course> course = courseRepository.findById(courseId);
		if (course.isPresent())
			courseRepository.delete(course.get());
		
	}
	

}
