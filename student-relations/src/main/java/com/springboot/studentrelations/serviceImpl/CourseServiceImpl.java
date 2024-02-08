package com.springboot.studentrelations.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentrelations.Dtos.CourseDTO;
import com.springboot.studentrelations.entity.CourseEntity;
import com.springboot.studentrelations.mapper.CourseMapper;
import com.springboot.studentrelations.repository.CourseRepository;
import com.springboot.studentrelations.repository.CourseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private final CourseRepository courseRepository;
	private final CourseMapper courseMapper;

	@Override
	public List<CourseDTO> findAllCourses() {
		return courseRepository.findAll().stream().map(courseMapper::courseEntityToCourseDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<CourseDTO> findCourseById(Long id) {
		return courseRepository.findById(id).map(courseMapper::courseEntityToCourseDTO);
	}

	@Override
	public CourseDTO saveCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = courseMapper.courseDTOToCourseEntity(courseDTO);
		CourseEntity savedEntity = courseRepository.save(courseEntity);
		return courseMapper.courseEntityToCourseDTO(savedEntity);
	}

	@Override
	public CourseDTO updateCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = courseMapper.courseDTOToCourseEntity(courseDTO);
		CourseEntity updatedEntity = courseRepository.save(courseEntity);
		return courseMapper.courseEntityToCourseDTO(updatedEntity);
	}

	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}
