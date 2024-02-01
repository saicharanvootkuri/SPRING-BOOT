package com.example1.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CourseController {

	// Course
	// Course:id,name,author
    @RequestMapping("/Courses")
	public List<Course> retriveAllCourses(){
		return Arrays.asList(
				
				new Course(1,"learn Aws","udemy"),
				new Course(2,"learn Devops","udemy"),
				new Course(3,"learn azure","udemy"),
				new Course(4,"learn GCP","udemy")
				);
		
		
	}

}
