package com.learningportal.learningportal.Repository;

import java.util.List;
import java.util.Optional;

import com.learningportal.learningportal.Entity.CourseEntity;

public interface CourseService {
	List<CourseEntity> findByCategory(String category);

	List<CourseEntity> findAllCourses();

	Optional<CourseEntity> findCourseById(Long id);

	CourseEntity saveCourse(CourseEntity courseEntity);

	CourseEntity updateCourse(CourseEntity courseEntity);

	void deleteCourse(Long id);

}
