package com.springboot.studentrelations.serviceImpl;
import java.util.List;
import com.springboot.studentrelations.entity.Student;

public interface StudentService {
 List<Student> getAllStudents();
 Student getStudentById(Long id);

}
