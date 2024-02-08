package com.springboot.studentrelations.Dtos;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String courseName;
    private String branch;
    private String subjects;

}
