package com.springboot.studentrelations.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

import com.springboot.studentrelations.Dtos.EnrollmentDTO;
import com.springboot.studentrelations.entity.Enrollment;

@Mapper
public interface EnrollmentMapper {
    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    @Mapping(source = "student", target = "studentDTO")
    @Mapping(source = "course", target = "courseDTO")
    EnrollmentDTO toDTO(Enrollment enrollment);

    @Mapping(source = "studentDTO", target = "student")
    @Mapping(source = "courseDTO", target = "course")
    Enrollment toEntity(EnrollmentDTO enrollmentDTO);
}
