package com.apple.internship.entity;



import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.internship.demo.common.ActiveStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
	
	@Column(name = "creation_date")
	private Date creationDate = new Date();

	@Column(name = "modify_date")
	private Date modifyDate;

	@Column(name = "ActiveStatus", length = 8)
	//@JsonView(Views.Thin.class)
	@Enumerated(EnumType.STRING)
	private ActiveStatus activeStatus = ActiveStatus.ACTIVE;

}
