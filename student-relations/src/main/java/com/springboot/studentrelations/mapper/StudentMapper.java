package com.springboot.studentrelations.mapper;

import org.mapstruct.Mapper;

import com.springboot.studentrelations.Dtos.StudentDTO;
import com.springboot.studentrelations.entity.StudentEntity;

@Mapper
public interface StudentMapper {

    StudentDTO studentEntityToStudentDTO(StudentEntity entity);

    StudentEntity studentDTOToStudentEntity(StudentDTO dto);
}
