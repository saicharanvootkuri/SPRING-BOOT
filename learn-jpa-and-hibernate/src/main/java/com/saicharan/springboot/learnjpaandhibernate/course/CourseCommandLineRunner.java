package com.saicharan.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.saicharan.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//	@Autowired
//
//	private CourseJpaRepository repository;
//	@Autowired
//
//	private CourseJpaRepository repository;
	@Autowired

	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS jpa", "sai charan"));
		repository.save(new Course(2, "Learn Fullstack jpa", "charan"));
		repository.save(new Course(3, "Learn Devops", "sai"));
		repository.save(new Course(4, "Learn QA", "vootkuri"));
		repository.save(new Course(5, "Learn Spring", "Bunty"));

		repository.deleteById(1l);

		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
	}

}
