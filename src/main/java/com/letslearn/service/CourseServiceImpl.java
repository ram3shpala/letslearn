package com.letslearn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letslearn.model.Course;
import com.letslearn.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository)
    {
        this.courseRepository=courseRepository;
    }

    public Course createCourse(Course course)
    {
        return courseRepository.save(course);
    }

    @Override
	public Optional<Course> getCourseById(long courseId) {
		return courseRepository.findById(courseId);
	}

	@Override
	public Iterable<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public void updateCourse(Long courseId, Course course) {

		courseRepository.findById(courseId).ifPresent(dbCourse -> {
			dbCourse.setName(course.getName());
			dbCourse.setCategory(course.getCategory());
			dbCourse.setDescription(course.getDescription());
			courseRepository.save(dbCourse);
		});
	}

	@Override
	public void deleteCourses() {
		courseRepository.deleteAll();
	}

	@Override
	public void deleteCourseById(long courseId) {
		courseRepository.deleteById(courseId);
	}
    
}
