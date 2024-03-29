package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseEntity;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Long> {

	@Query(value = "SELECT * FROM courses WHERE course_id = :courseId", nativeQuery = true)
	List<CourseEntity> findCoursesByStudentId(@Param("courseId") Long courseId);
}
