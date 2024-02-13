
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CourseEntity;
import com.example.demo.repository.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

	private final CourseService courseService;
	private final Logger log = LoggerFactory.getLogger(CourseController.class);

	@GetMapping("/all")
	public List<CourseEntity> findAllCourses() {
		log.info("Fetching all courses");
		return courseService.findAllCourses();
	}

	@GetMapping()
	public ResponseEntity<Optional<CourseEntity>> findCourseById(@RequestParam("id") Long id) {
		log.info("Fetching course with id: {}", id);
		Optional<CourseEntity> result = courseService.findCourseById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping("/courses")
	public CourseEntity saveCourse(@RequestBody CourseEntity courseEntity) {
		log.info("Saving course: {}", courseEntity);
		return courseService.saveCourse(courseEntity);
	}

	@PutMapping("/courses")
	public CourseEntity updateCourse(@RequestBody CourseEntity courseEntity) {
		log.info("Updating course: {}", courseEntity);
		return courseService.updateCourse(courseEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable("id") Long id) {
		log.info("Deleting course with id: {}", id);
		courseService.deleteCourse(id);
	}
}