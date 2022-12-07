package com.letslearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.letslearn.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
