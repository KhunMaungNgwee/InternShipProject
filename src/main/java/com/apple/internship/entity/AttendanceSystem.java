package com.apple.internship.entity;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="attendance_system")
public class  AttendanceSystem extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stu_id" ,length=50)
	private Long stu_id;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long courseId;
	
	@Column(name="module_no",length=20)
	private String moduleNo;
	
	@Column(name="date")
	private Date date = new Date();
	
	@Column(name="att_record")
	private String attRecord;
	
	
}
