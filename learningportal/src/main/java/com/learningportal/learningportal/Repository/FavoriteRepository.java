package com.learningportal.learningportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.learningportal.Entity.FavoriteEntity;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {

}
