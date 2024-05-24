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
import com.apple.internship.entity.Course;
import com.apple.internship.service.CourseService;
import com.apple.internship.common.Response;
import com.apple.internship.common.ActiveStatus;
@RestController
@RequestMapping("/course/")
@CrossOrigin(origins="*")
public class CourseController {
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Response<Course> getAll() {
		Response<Course> response = new Response<>();
		try {
			List<Course> result = courseService.getAll();
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
	public Response<Course> create(@RequestBody Course course){
		Response<Course> response = new Response<>();
		try {
			Course result = courseService.create(course);
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
	public Response<Course> update(@RequestBody Course course) {
		Response<Course> response = new Response<>();
		
		try {
			Optional<Course> existingData = courseService.getCourseById(course.getCourseId());
			if(existingData.isPresent()) {
				Course oldData = existingData.get();
				oldData = course;//transfer
				oldData.setModifyDate(new Date());
				response.setData(courseService.create(oldData));
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
	public Response<Course> delete(@RequestParam Long courseId) {
		Response<Course> response = new Response<>();
		try {
			Optional<Course> existingData = courseService.getCourseById(courseId);
			if(existingData.isPresent()) {
				Course oldData = existingData.get();
				oldData.setActiveStatus(ActiveStatus.DELETE);;
				oldData.setModifyDate(new Date());
				courseService.create(oldData);
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
