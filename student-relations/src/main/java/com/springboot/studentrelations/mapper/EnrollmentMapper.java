package com.springboot.studentrelations.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.springboot.studentrelations.Dtos.EnrollmentDTO;
import com.springboot.studentrelations.entity.EnrollmentEntity;

@Mapper
public interface EnrollmentMapper {

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    EnrollmentDTO enrollmentToEnrollmentDTO(EnrollmentEntity enrollment);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    EnrollmentEntity enrollmentDTOToEnrollment(EnrollmentDTO enrollmentDTO);
}
