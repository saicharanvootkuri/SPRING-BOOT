package com.springboot.studentrelations.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.studentrelations.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
