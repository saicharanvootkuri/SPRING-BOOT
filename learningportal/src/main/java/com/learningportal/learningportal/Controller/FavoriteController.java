package com.learningportal.learningportal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.learningportal.Repository.FavoriteService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;

}
