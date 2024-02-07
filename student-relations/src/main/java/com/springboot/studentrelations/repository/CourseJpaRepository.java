package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.entity.Course;

public interface CourseJpaRepository {
	List<Course> findAllStudents();
	Optional<Course> findById(Long id);
	Course saveStudent(Course studentEntity);
	Course updateStudent(Course studentEntity);
	void deleteStudent(Long id);
}
