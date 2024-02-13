package com.learningportal.learningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.learningportal.entity.CategoryEntity;
import com.learningportal.learningportal.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	List<CourseEntity> findByCategoryEntity(CategoryEntity categoryEntity);

	CourseEntity findByAuthor(String author);
}