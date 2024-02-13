package com.learningportal.learningportal.entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class UserEntity {

	public enum Roles {
		ADMIN, LEARNER, AUTHOR
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_role")
	@Enumerated(EnumType.STRING)
	private Roles role;

	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private List<RegistrationEntity> enrolledCourses;

	@OneToMany(mappedBy = "userFavEntity", cascade = CascadeType.ALL)
	private List<FavouriteEntity> favouriteCourses;

}