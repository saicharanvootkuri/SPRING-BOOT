package com.springboot.studentrelations.Dtos;

import lombok.Data;

@Data
public class EnrollmentDTO {
    private Long id;
    private StudentDTO student;
    private CourseDTO course;

}
