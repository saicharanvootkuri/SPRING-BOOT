package com.example1.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CurrencyConfigurationController {
    @Autowired
    
    private CurrencyServiceConfiguration configuration;
	// Course
	// Course:id,name,author
    @RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration retriveAllCourses(){
		return configuration ;		
		
	}

}
