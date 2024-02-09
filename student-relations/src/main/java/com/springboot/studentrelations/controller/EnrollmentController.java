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

import com.springboot.studentrelations.Dtos.EnrollmentDTO;
import com.springboot.studentrelations.repository.EnrollmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/enrollments")
public class EnrollmentController {

	private final EnrollmentService enrollmentService;

	@GetMapping
	public List<EnrollmentDTO> findAllEnrollments() {
		return enrollmentService.findAllEnrollments();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<EnrollmentDTO>> findEnrollmentById(@PathVariable("id") Long id) {
		Optional<EnrollmentDTO> result = enrollmentService.findEnrollmentById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}
	}

	@PostMapping
	public EnrollmentDTO saveEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
		return enrollmentService.saveEnrollment(enrollmentDTO);
	}

	@PutMapping
	public EnrollmentDTO updateEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
		return enrollmentService.updateEnrollment(enrollmentDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteEnrollment(@PathVariable("id") Long id) {
		enrollmentService.deleteEnrollment(id);
	}
}
