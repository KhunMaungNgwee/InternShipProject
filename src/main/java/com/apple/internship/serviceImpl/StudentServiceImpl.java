package com.apple.internship.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.internship.entity.Student;
import com.apple.internship.repository.StudentRepository;
import com.apple.internship.service.StudentService;
import com.apple.internship.common.ActiveStatus;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentRepository.getAllByActiveStatus(ActiveStatus.ACTIVE);
	}

	@Override
	public Optional<Student> getStudentById(Long Stu_id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(Stu_id);
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void delete(Long Stu_id) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepository.findById(Stu_id);
		if (student.isPresent())
			studentRepository.delete(student.get());
		
	}

}
