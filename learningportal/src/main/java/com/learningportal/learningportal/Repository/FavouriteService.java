package com.learningportal.learningportal.repository;

import java.util.List;
import java.util.Optional;

import com.learningportal.learningportal.dto.FavouriteResponseDto;
import com.learningportal.learningportal.entity.CourseEntity;
import com.learningportal.learningportal.entity.FavouriteEntity;
import com.learningportal.learningportal.entity.UserEntity;

public interface FavouriteService {
	public List<FavouriteEntity> findAllFavourites();

	public Optional<FavouriteEntity> findFavouriteById(Long id);

	public void saveFavourite(FavouriteEntity favouriteEntity);

	public List<FavouriteEntity> findFavouriteByUserEntity(UserEntity userEntity);

	public List<FavouriteEntity> findFavouriteByCourseEntity(CourseEntity courseEntity);

	public FavouriteEntity getFavouriteByUserAndCourse(UserEntity userEntity, CourseEntity courseEntity);

	public boolean checkFavouriteByUserAndCourse(UserEntity userEntity, CourseEntity courseEntity);

	public void removeFavourite(FavouriteEntity favouriteEntity);

	public FavouriteResponseDto mapFavouriteEntitytoDto(FavouriteEntity favouriteEntity);
}