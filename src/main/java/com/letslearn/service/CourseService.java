package com.letslearn.service;

import java.util.Optional;

import com.letslearn.model.Course;

public interface CourseService {

    Course createCourse(Course course);
	
	Optional<Course> getCourseById(long courseId);
	
	Iterable<Course> getCourses();
	
	void updateCourse(Long courseId, Course course);
	
	void deleteCourseById(long courseId);

	void deleteCourses();
    
}
