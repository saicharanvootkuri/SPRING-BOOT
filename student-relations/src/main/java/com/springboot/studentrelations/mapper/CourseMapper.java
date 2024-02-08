package com.springboot.studentrelations.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component; // Import Component annotation

import com.springboot.studentrelations.Dtos.CourseDTO;
import com.springboot.studentrelations.entity.CourseEntity;

@Component
@Mapper
public interface CourseMapper {

	@Mapping(target = "id", source = "entity.id")
	@Mapping(target = "branch", source = "entity.branch")
	@Mapping(target = "subjects", source = "entity.subjects")
	CourseDTO courseEntityToCourseDTO(CourseEntity entity);

	@Mapping(target = "id", source = "dto.id")
	@Mapping(target = "branch", source = "dto.branch")
	@Mapping(target = "subjects", source = "dto.subjects")
	CourseEntity courseDTOToCourseEntity(CourseDTO dto);
}
