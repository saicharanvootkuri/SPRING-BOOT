package com.Student.springboot.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//@Data
@Entity(name = "CourseEntity")
@Table(name = "courses")
public class CourseEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "course_id")
	    private long id;

	    @ManyToOne
	    @JoinColumn(name = "student_id", nullable = false)
	    private StudentEntity student;
	    
	    @Column(name = "branch")
		private String branch;
		
		@Column(name="subjects")
		private String subjects;
		

	public CourseEntity() {

	}

	public CourseEntity(long id, String firstName,String branch,String subjects) {

		this.id = id;
		this.branch = branch;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
}
	
