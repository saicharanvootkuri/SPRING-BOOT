package com.learningportal.learningportal.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class FavouriteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private UserEntity userFavEntity;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "course_id")
	private CourseEntity courseFavEntity;

}