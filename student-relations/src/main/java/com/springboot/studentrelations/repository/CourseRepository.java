package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.studentrelations.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
