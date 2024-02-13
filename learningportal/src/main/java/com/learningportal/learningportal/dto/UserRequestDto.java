package com.learningportal.learningportal.dto;

import com.learningportal.learningportal.entity.UserEntity;

import lombok.Data;

@Data
public class UserRequestDto {

	private String name;
	private UserEntity.Roles role;
}