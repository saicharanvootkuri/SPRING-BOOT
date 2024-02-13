package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseEntity;
import com.example.demo.entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

	@Query(value = "SELECT * FROM students WHERE student_id = :studentId", nativeQuery = true)
	List<CourseEntity> findCoursesByStudentId(@Param("studentId") Long studentId);

}
