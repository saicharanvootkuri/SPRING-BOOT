package com.Student.springboot.studentmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.Student.springboot.studentmanagement.entity.CourseEntity;

public interface CourseJpaRepo {
	List<CourseEntity> findAllStudents();
	Optional<CourseEntity> findById(Long id);
	CourseEntity saveStudent(CourseEntity studentEntity);
	CourseEntity updateStudent(CourseEntity studentEntity);
	void deleteStudent(Long id);
}
