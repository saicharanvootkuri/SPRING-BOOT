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

import com.springboot.studentrelations.entity.Enrollment;
import com.springboot.studentrelations.repository.EnrollmentJpaRepository;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentJpaRepository enrollmentRepository;

    public EnrollmentController(EnrollmentJpaRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Enrollment>> getEnrollmentById(@PathVariable("id") Long id) {
        Optional<Enrollment> result = enrollmentRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(result);
        }
    }

    @PostMapping
    public Enrollment saveEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable("id") Long id, @RequestBody Enrollment enrollment) {
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findById(id);
        if (existingEnrollment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            enrollment.setId(id);
            Enrollment updatedEnrollment = enrollmentRepository.save(enrollment);
            return ResponseEntity.status(HttpStatus.OK).body(updatedEnrollment);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable("id") Long id) {
        enrollmentRepository.deleteById(id);
    }
}
