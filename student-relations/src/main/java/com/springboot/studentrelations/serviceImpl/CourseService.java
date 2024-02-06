package com.springboot.studentrelations.serviceImpl;
import java.util.List;
import com.springboot.studentrelations.entity.Course;

public interface CourseService {
	List<Course> getAllCourses();

	Course getCourseById(Long id);

}
