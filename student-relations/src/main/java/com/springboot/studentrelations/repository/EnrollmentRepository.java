package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.studentrelations.entity.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
