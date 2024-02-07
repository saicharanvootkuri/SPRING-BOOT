package com.springboot.studentrelations.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springboot.studentrelations.Dtos.StudentDTO;
import com.springboot.studentrelations.entity.Student;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);
}
