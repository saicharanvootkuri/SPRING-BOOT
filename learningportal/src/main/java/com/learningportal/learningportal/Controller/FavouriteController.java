package com.learningportal.learningportal.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.learningportal.dto.FavouriteResponseDto;
import com.learningportal.learningportal.entity.FavouriteEntity;
import com.learningportal.learningportal.repository.FavouriteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/favourites")
public class FavouriteController {

	private FavouriteService favouriteService;

	@GetMapping
	public ResponseEntity<Object> showAllCategories() {
		List<FavouriteEntity> favourites = favouriteService.findAllFavourites();
		if (favourites.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No favourites found!");
		}
		List<FavouriteResponseDto> favouritesresp = favourites.stream().map(favouriteService::mapFavouriteEntitytoDto)
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(favouritesresp);
	}
}