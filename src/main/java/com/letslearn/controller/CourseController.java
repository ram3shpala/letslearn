package com.letslearn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letslearn.model.Course;
import com.letslearn.service.CourseService;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    
    @GetMapping
	public Iterable<Course> getAllCourses() {
		return courseService.getCourses();
	}
	
	@GetMapping("{id}")
	public Optional<Course> getCourseById(@PathVariable("id") long courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	@PutMapping("{id}")
	public void updateCourse(@PathVariable("id") long courseId, @RequestBody Course course) {
		courseService.updateCourse(courseId, course);
	}
	
	@DeleteMapping("{id}")
	void deleteCourseById(@PathVariable("id") long courseId) {
		courseService.deleteCourseById(courseId);
	}
	
	@DeleteMapping
	void deleteCourses() {
		courseService.deleteCourses();
	}
}