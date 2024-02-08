package com.springboot.studentrelations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.studentrelations.mapper")
public class StudentRelationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentRelationsApplication.class, args);
	}
}
