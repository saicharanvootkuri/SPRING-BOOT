package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.studentrelations.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
