package com.learningportal.learningportal.repository;

import java.util.List;
import java.util.Optional;

import com.learningportal.learningportal.dto.CourseResponseDto;
import com.learningportal.learningportal.dto.RegistrationResponseDto;
import com.learningportal.learningportal.entity.CourseEntity;
import com.learningportal.learningportal.entity.RegistrationEntity;
import com.learningportal.learningportal.entity.UserEntity;

public interface RegistrationService {
	public List<RegistrationEntity> findAllRegistrations();

	public Optional<RegistrationEntity> findRegistrationById(Long id);

	public void saveRegistration(RegistrationEntity registrationEntity);

	public boolean checkRegistrationByUserAndCourse(UserEntity userEntity, CourseEntity courseEntity);

	public boolean checkRegistrationByUser(UserEntity userEntity);

	public List<RegistrationEntity> findRegistrationByUserEntity(UserEntity userEntity);

	public List<RegistrationEntity> findRegistrationByCourseEntity(CourseEntity courseEntity);

	public List<CourseResponseDto> findEnrolledCoursesByUser(UserEntity userEntity);

	public RegistrationResponseDto mapRegistrationEntitytoDto(RegistrationEntity registrationEntity);

	public void removeRegistration(RegistrationEntity registrationEntity);

	public RegistrationEntity getRegistrationByUserAndCourse(UserEntity userEntity, CourseEntity courseEntity);
}