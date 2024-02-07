package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.studentrelations.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
