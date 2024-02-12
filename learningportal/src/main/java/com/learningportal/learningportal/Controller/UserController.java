package com.learningportal.learningportal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.learningportal.Repository.UserService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

}
