package com.learningportal.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.learningportal.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}