package com.apple.internship.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="student")


public class Student extends AbstractEntity implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stu_id" ,length=50)
	private Long Stu_id;
	
	@Column(name="stu_name" ,length=50)
	private String studentName;
	
	@Column(name="major_name",length=90)
	private String majorName;
	
	@Column(name="stu_email" ,length=90)
	private String studentEmail;
	
	@Column(name="stu_pwd",length=15)
	private String studentPwd;
	
	@ManyToMany
	@JoinTable(
			name = "student_course",
	        joinColumns = @JoinColumn ( name = "student_id"),
	        inverseJoinColumns = @JoinColumn (name = "course_id"))
	private List<Course> course; 	
	}
