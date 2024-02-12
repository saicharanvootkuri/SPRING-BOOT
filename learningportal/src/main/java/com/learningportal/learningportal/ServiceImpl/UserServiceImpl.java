package com.learningportal.learningportal.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.learningportal.Entity.UserEntity;
import com.learningportal.learningportal.Repository.UserRepository;
import com.learningportal.learningportal.Repository.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity userEntity) {
		// Implement logic to create a new user
		return userRepository.save(userEntity);
	}

	@Override
	public Optional<UserEntity> findUserByUsername(String username) {
		// Implement logic to find a user by username
		return userRepository.findByUsername(username);
	}

	// Add other methods as needed for user-related operations
}
