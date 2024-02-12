package com.learningportal.learningportal.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.Entity.CourseEntity;
import com.learningportal.learningportal.Entity.FavoriteEntity;
import com.learningportal.learningportal.Entity.UserEntity;
import com.learningportal.learningportal.Repository.FavoriteRepository;
import com.learningportal.learningportal.Repository.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	private FavoriteRepository favoriteRepository;

	@Override
	public List<FavoriteEntity> getFavoritesByUser(UserEntity userEntity) {
		// Implement logic to retrieve favorites by user
		return favoriteRepository.findByUser(userEntity);
	}

	@Override
	public void addFavorite(UserEntity userEntity, CourseEntity course) {
		// Implement logic to add a course to user's favorites
		FavoriteEntity favorite = new FavoriteEntity();
		favorite.setUser(userEntity);
		favorite.setCourse(course);
		favoriteRepository.save(favorite);
	}

	// Add other methods as needed for favorite-related operations
}
