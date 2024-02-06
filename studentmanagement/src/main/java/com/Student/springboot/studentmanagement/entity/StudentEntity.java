package com.Student.springboot.studentmanagement.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@EntityListeners(AuditingEntityListener.class)
@Data
@Entity(name = "student")
@Table(name = "students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "branch")
	private String branch;

	@Column(name = "mobile_number")
	private String mobileNumber;


@JsonFormat(pattern="MM/dd/yyyy HH:mm")
@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
@CreatedDate
private LocalDateTime createdDate;

@JsonFormat(pattern="MM/dd/yyyy HH:mm")
@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
@LastModifiedDate
private LocalDateTime lastModifiedDate;

}