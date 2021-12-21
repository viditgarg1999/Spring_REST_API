package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is the Home Page";
	}
	
	
	// To get the Courses
	@GetMapping("/courses")
	public List<Course> getcourses()
	{
		return this.courseService.getCourses();
	}
	
	
	// To get single course
	@GetMapping("/courses/{courseId}")
	public Course getcourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	
	// To add a course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	// To update a course
	@PutMapping("/courses")
	public String updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	// To delete a course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> removeCourse(@PathVariable String courseId)
	{
		try {
			this.courseService.removeCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
