package com.apple.internship.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.apple.internship.entity.Student;
import com.apple.internship.service.StudentService;
import com.internship.demo.common.ActiveStatus;
import com.internship.demo.common.Response;


@RestController
@RequestMapping("/student/")
@CrossOrigin(origins = "*")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Student> getAll() {
		Response<Student> response = new Response<>();
		try {
			List<Student> result = studentService.getAll();
			response.setMessage("All user list");
			response.setData(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}

		return response;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Response<Student> create(@RequestBody Student student){
		Response<Student> response = new Response<>();
		try {
			Student result = studentService.create(student);
			response.setData(result);
			response.setMessage("Successfult insert");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//throw new RuntimeException(e.toString());
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}
		return response;

	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<Student> update(@RequestBody Student student) {
		Response<Student> response = new Response<>();
		
		try {
			Optional<Student> existingData = studentService.getStudentById(student.getStu_id());
			if(existingData.isPresent()) {
				Student oldData = existingData.get();
				oldData = student;//transfer
				oldData.setModifyDate(new Date());
				response.setData(studentService.create(oldData));
				response.setMessage("Update success");
			}else {
				response.setMessage("No existing data");
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}
		return response;
		

	}


	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public Response<Student> delete(@RequestParam Long stu_id) {
		Response<Student> response = new Response<>();
		try {
			Optional<Student> existingData = studentService.getStudentById(stu_id);
			if(existingData.isPresent()) {
				Student oldData = existingData.get();
				oldData.setActiveStatus(ActiveStatus.DELETE);;
				oldData.setModifyDate(new Date());
				studentService.create(oldData);
				response.setMessage("Delete success");
			}else {
				response.setMessage("No existing data");
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Internal server error");
			return response;
		}
		return response;

	}

}
