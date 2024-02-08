package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.studentrelations.entity.EnrollmentEntity;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
}
