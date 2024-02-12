package com.learningportal.learningportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.learningportal.Entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
