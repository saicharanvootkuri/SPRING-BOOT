package com.springboot.studentrelations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studentrelations.Dtos.CourseDTO;
import com.springboot.studentrelations.repository.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {
	private final CourseService courseService;

	@GetMapping
	public List<CourseDTO> findAllCourses() {
		return courseService.findAllCourses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<CourseDTO>> findCourseById(@PathVariable("id") Long id) {
		Optional<CourseDTO> result = courseService.findCourseById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping
	public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
		return courseService.saveCourse(courseDTO);
	}

	@PutMapping
	public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
		return courseService.updateCourse(courseDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
	}
}
