package com.learningportal.learningportal.Repository;

import java.util.Optional;

import com.learningportal.learningportal.Entity.UserEntity;

public interface UserService {
	Optional<UserEntity> findByUsername(String username);

}
