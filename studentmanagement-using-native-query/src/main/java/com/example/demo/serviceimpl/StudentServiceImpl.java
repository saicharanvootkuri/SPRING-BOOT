package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepo studentRepo;
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	public StudentServiceImpl(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public List<StudentEntity> findAllStudents() {
		log.info("Fetching all students.");
		return studentRepo.findAll();
	}

	@Override
	public Optional<StudentEntity> findStudentById(Long id) {
		log.info("Fetching student by ID: {}", id);
		return studentRepo.findById(id);
	}

	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		log.info("Saving new student: {}", studentEntity);
		return studentRepo.save(studentEntity);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity studentEntity) {
		log.info("Updating student: {}", studentEntity);
		return studentRepo.save(studentEntity);
	}

	@Override
	public void deleteStudent(Long id) {
		log.info("Deleting student with ID: {}", id);
		studentRepo.deleteById(id);
	}

}