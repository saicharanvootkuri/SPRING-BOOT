package com.learningportal.learningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.learningportal.entity.CourseEntity;
import com.learningportal.learningportal.entity.RegistrationEntity;
import com.learningportal.learningportal.entity.UserEntity;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
	public RegistrationEntity findByUserEntityAndCourseEntity(UserEntity userEntity, CourseEntity courseEntity);

	public List<RegistrationEntity> findByUserEntity(UserEntity userEntity);

	public List<RegistrationEntity> findByCourseEntity(CourseEntity courseEntity);
}
