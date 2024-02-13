package com.learningportal.learningportal.repository;

import java.util.List;
import java.util.Optional;

import com.learningportal.learningportal.dto.UserResponseDto;
import com.learningportal.learningportal.entity.UserEntity;

public interface UserService {
	public List<UserEntity> findAllUsers();

	public Optional<UserEntity> findUserById(Long id);

	public UserEntity addUser(UserEntity userEntity);

	public UserResponseDto userEntitytoDtoMapper(UserEntity userEntity);

	public void removeUserById(Long id);
}