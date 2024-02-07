package com.springboot.studentrelations.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springboot.studentrelations.Dtos.CourseDTO;
import com.springboot.studentrelations.entity.Course;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toDTO(Course course);

    Course toEntity(CourseDTO courseDTO);
}
