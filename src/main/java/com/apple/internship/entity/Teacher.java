package com.apple.internship.entity;

import java.io.Serializable;

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
@Table(name="teacher")
public class Teacher extends AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Tr_id;
	
	@Column(name="Tr_name",length=50)
	private String trName;
	
	@Column(name="tr_email",length=20)
	private String trEmail;
	
	@Column(name="tr_psw",length=20)
	private String trPsw;
	
	@Column(name="module_no",length=20)
	private String moduleNo;

}
