package com.learningportal.learningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.learningportal.entity.CourseEntity;
import com.learningportal.learningportal.entity.FavouriteEntity;
import com.learningportal.learningportal.entity.UserEntity;

@Repository
public interface FavouriteRepository extends JpaRepository<FavouriteEntity, Long> {
	public FavouriteEntity findByUserFavEntityAndCourseFavEntity(UserEntity userEntity, CourseEntity courseEntity);

	public List<FavouriteEntity> findByUserFavEntity(UserEntity userEntity);

	public List<FavouriteEntity> findByCourseFavEntity(CourseEntity courseEntity);
}