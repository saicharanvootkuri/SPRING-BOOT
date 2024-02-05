package com.Student.springboot.studentmanagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@Data
@Entity(name = "StudentEntity")
@Table(name = "students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long id;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<CourseEntity> courses;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "branch")
	private String branch;

	@Column(name = "mobile_number")
	private String mobileNumber;

	public StudentEntity() {

	}

	public StudentEntity(long id, String firstName, String lastName, String studentIdNumber, String branch,
			String mobileNumber) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.mobileNumber = mobileNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
