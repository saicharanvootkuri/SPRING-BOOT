package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.Dtos.CourseDTO;

public interface CourseService {

    List<CourseDTO> findAllCourses();

    Optional<CourseDTO> findCourseById(Long id);

    CourseDTO saveCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(CourseDTO courseDTO);

    void deleteCourse(Long id);
}
