package com.learningportal.learningportal.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.Entity.CourseEntity;
import com.learningportal.learningportal.Repository.CourseRepository;
import com.learningportal.learningportal.Repository.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<CourseEntity> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public List<CourseEntity> getCoursesByCategory(String category) {
		return courseRepository.findByCategory(category);
	}

	@Override
	public CourseEntity createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public CourseEntity getCourseById(Long courseId) {
		return courseRepository.findById(courseId)
				.orElseThrow(() -> new NotFoundException("Course not found with id: " + courseId));
	}

	@Override
	public CourseEntity updateCourse(Long courseId, CourseEntity updatedCourse) {
		CourseEntity existingCourse = getCourseById(courseId);

		existingCourse.setTitle(updatedCourse.getTitle());
		existingCourse.setDescription(updatedCourse.getDescription());
		existingCourse.setCategory(updatedCourse.getCategory());

		return courseRepository.save(existingCourse);
	}

	@Override
	public void deleteCourse(Long courseId) {
		CourseEntity existingCourse = getCourseById(courseId);
		courseRepository.delete(existingCourse);
	}
}