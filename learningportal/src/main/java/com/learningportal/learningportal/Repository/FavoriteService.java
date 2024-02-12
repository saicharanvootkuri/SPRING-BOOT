package com.learningportal.learningportal.Repository;

import java.util.List;

import com.learningportal.learningportal.Entity.FavoriteEntity;
import com.learningportal.learningportal.Entity.UserEntity;

public interface FavoriteService {
	List<FavoriteEntity> findByUser(UserEntity user);

}
