package com.learningportal.learningportal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.dto.FavouriteResponseDto;
import com.learningportal.learningportal.entity.CourseEntity;
import com.learningportal.learningportal.entity.FavouriteEntity;
import com.learningportal.learningportal.entity.UserEntity;
import com.learningportal.learningportal.repository.FavouriteRepository;
import com.learningportal.learningportal.repository.FavouriteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FavouriteServiceImpl implements FavouriteService {

	private static final Logger logger = LoggerFactory.getLogger(FavouriteServiceImpl.class);

	private FavouriteRepository favouriteRepository;

	@Override
	public List<FavouriteEntity> findAllFavourites() {
		logger.info("@FavouriteServiceImpl - Fetching all favourites.");
		return favouriteRepository.findAll();
	}

	@Override
	public Optional<FavouriteEntity> findFavouriteById(Long id) {
		logger.info("@FavouriteServiceImpl - Finding favourite using id.");
		return favouriteRepository.findById(id);
	}

	@Override
	public void saveFavourite(FavouriteEntity favouriteEntity) {
		logger.info("@FavouriteServiceImpl - Adding favourite using favourite entity.");
		favouriteRepository.save(favouriteEntity);
	}

	@Override
	public List<FavouriteEntity> findFavouriteByUserEntity(UserEntity userEntity) {
		logger.info("@FavouriteServiceImpl - Fetching favourites of user.");
		return favouriteRepository.findByUserFavEntity(userEntity);
	}

	@Override
	public List<FavouriteEntity> findFavouriteByCourseEntity(CourseEntity courseEntity) {
		logger.info("@FavouriteServiceImpl - Fetching favourites by course.");
		return favouriteRepository.findByCourseFavEntity(courseEntity);
	}

	@Override
	public FavouriteEntity getFavouriteByUserAndCourse(UserEntity userEntity, CourseEntity courseEntity) {
		logger.info("@FavouriteServiceImpl - Fetching favourite of user for a course.");
		return favouriteRepository.findByUserFavEntityAndCourseFavEntity(userEntity, courseEntity);
	}

	@Override
	public boolean checkFavouriteByUserAndCourse(UserEntity userEntity, CourseEntity courseEntity) {
		logger.info("@FavouriteServiceImpl - Checking if user favourited a course.");
		FavouriteEntity favourite = favouriteRepository.findByUserFavEntityAndCourseFavEntity(userEntity, courseEntity);
		if (favourite == null) {
			return false;
		}
		return true;
	}

	@Override
	public void removeFavourite(FavouriteEntity favouriteEntity) {
		logger.info("@FavouriteServiceImpl - Removing a favourite.");
		favouriteRepository.delete(favouriteEntity);
	}

	@Override
	public FavouriteResponseDto mapFavouriteEntitytoDto(FavouriteEntity favouriteEntity) {
		logger.info("@FavouriteServiceImpl - FavouriteEntity to FavouriteDTO Mapper.");
		FavouriteResponseDto favouriteDto = new FavouriteResponseDto();
		favouriteDto.setId(favouriteEntity.getId());
		favouriteDto.setUserName(favouriteEntity.getUserFavEntity().getName());
		favouriteDto.setCourseName(favouriteEntity.getCourseFavEntity().getName());
		return favouriteDto;
	}

}