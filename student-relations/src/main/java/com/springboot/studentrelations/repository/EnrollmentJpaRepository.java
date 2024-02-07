package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.entity.Enrollment;

public interface EnrollmentJpaRepository {
	List<Enrollment> findAllStudents();
	Optional<Enrollment> findById(Long id);
	Enrollment saveStudent(Enrollment studentEntity);
	Enrollment updateStudent(Enrollment studentEntity);
	void deleteStudent(Long id);
}
