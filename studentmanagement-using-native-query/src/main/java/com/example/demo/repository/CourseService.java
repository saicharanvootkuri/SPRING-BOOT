package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CourseEntity;

public interface CourseService {
	List<CourseEntity> findAllCourses();

	Optional<CourseEntity> findCourseById(Long id);

	CourseEntity saveCourse(CourseEntity courseEntity);

	CourseEntity updateCourse(CourseEntity courseEntity);

	void deleteCourse(Long id);

	List<CourseEntity> findCoursesByStudentId(Long studentId);
}
