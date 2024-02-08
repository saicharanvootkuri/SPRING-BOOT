package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.studentrelations.entity.CourseEntity;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
