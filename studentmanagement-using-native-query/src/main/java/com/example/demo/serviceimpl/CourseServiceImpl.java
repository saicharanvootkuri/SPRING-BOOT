package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CourseEntity;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepo courseRepo;
	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	public CourseServiceImpl(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}

	@Override
	public List<CourseEntity> findAllCourses() {
		log.info("Fetching all courses.");
		return courseRepo.findAll();
	}

	@Override
	public Optional<CourseEntity> findCourseById(Long id) {
		log.info("Fetching course by ID: {}", id);
		return courseRepo.findById(id);
	}

	@Override
	public CourseEntity saveCourse(CourseEntity courseEntity) {
		log.info("Saving new course: {}", courseEntity);
		return courseRepo.save(courseEntity);
	}

	@Override
	public CourseEntity updateCourse(CourseEntity courseEntity) {
		log.info("Updating course: {}", courseEntity);
		return courseRepo.save(courseEntity);
	}

	@Override
	public void deleteCourse(Long id) {
		log.info("Deleting course with ID: {}", id);
		courseRepo.deleteById(id);
	}

	@Override
	public List<CourseEntity> findCoursesByStudentId(Long studentId) {
		log.info("Fetching courses by student ID: {}", studentId);
		return courseRepo.findCoursesByStudentId(studentId);
	}
}
