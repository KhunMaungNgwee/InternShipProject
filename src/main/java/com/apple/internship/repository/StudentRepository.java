package com.apple.internship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apple.internship.entity.Student;
import com.apple.internship.common.ActiveStatus;


public interface StudentRepository extends JpaRepository<Student, Long> {
@Query("select u from Student u where u.activeStatus= :activeStatus")
List<Student> getAllByActiveStatus(@Param("activeStatus")ActiveStatus activeStatus);
}
