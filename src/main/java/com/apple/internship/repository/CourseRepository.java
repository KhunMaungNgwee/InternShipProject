package com.apple.internship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apple.internship.entity.Course;

import com.apple.internship.common.ActiveStatus;

public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query("select u from Course u where u.activeStatus= :activeStatus")
	List<Course> getAllByActiveStatus(@Param("activeStatus")ActiveStatus activeStatus);

}
