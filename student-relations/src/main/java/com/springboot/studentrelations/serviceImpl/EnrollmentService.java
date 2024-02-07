package com.springboot.studentrelations.serviceImpl;
import java.util.List;

import com.springboot.studentrelations.Dtos.EnrollmentDTO;

public interface EnrollmentService {
    List<EnrollmentDTO> getAllEnrollments();

    EnrollmentDTO getEnrollmentById(Long id);

    EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO);

    EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO enrollmentDTO);

    void deleteEnrollment(Long id);
}
