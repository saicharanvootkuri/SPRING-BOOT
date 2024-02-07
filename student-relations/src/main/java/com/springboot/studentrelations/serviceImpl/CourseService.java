package com.springboot.studentrelations.serviceImpl;

import java.util.List;

import com.springboot.studentrelations.Dtos.CourseDTO;

public interface CourseService {
    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    CourseDTO saveCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);
}
