package com.apple.internship.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="course")
public class Course extends AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long courseId;
	
	@Column(name="course_name",length=50)
	private String courseName;
	
	@Column(name="module_no",length=50)
	private String moduleNo;
	
	@Column(name="major_name",length=50)
	private String majorName;
	
	@Column(name="total_att")
	private String totalAtt;
	
	@Column(name="Duration")
	private int Duration;
	
	@ManyToMany(mappedBy="course")
	private List<Student> student;
	

}
