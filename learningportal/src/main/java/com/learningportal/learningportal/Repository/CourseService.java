package com.learningportal.learningportal.repository;

import java.util.List;
import java.util.Optional;

import com.learningportal.learningportal.dto.CourseResponseDto;
import com.learningportal.learningportal.entity.CategoryEntity;
import com.learningportal.learningportal.entity.CourseEntity;

public interface CourseService {
	public List<CourseEntity> findAllCourse();

	public Optional<CourseEntity> findCourseById(Long id);

	public CourseEntity addCourse(CourseEntity courseEntity);

	public List<CourseEntity> findCourseByCategory(CategoryEntity categoryEntity);

	public CourseEntity findCourseByAuthor(String author);

	public CourseResponseDto mapCourseEntitytoCourseDto(CourseEntity courseEntity);

	public void deleteCourseById(Long id);
}
