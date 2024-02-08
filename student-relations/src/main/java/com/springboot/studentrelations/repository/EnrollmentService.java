package com.springboot.studentrelations.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.studentrelations.Dtos.EnrollmentDTO;

public interface EnrollmentService {

    List<EnrollmentDTO> findAllEnrollments();

    Optional<EnrollmentDTO> findEnrollmentById(Long id);

    EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO);

    EnrollmentDTO updateEnrollment(EnrollmentDTO enrollmentDTO);

    void deleteEnrollment(Long id);
}
