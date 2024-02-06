package com.springboot.studentrelations.serviceImpl;

import java.util.List;

import com.springboot.studentrelations.entity.Enrollment;

public interface EnrollmentService {
	List<Enrollment> getAllEnrollments();

	Enrollment getEnrollmentById(Long id);
}
