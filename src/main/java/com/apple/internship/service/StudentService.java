package com.apple.internship.service;

import java.util.List;
import java.util.Optional;

import com.apple.internship.entity.Student;

public interface StudentService {

	public List<Student> getAll();

	public Student create(Student student);

	public void delete(Long Stu_id);

	public Optional<Student> getStudentById(Long Stu_id);

}
