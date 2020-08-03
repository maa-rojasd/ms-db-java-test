package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="PHONE")
public class PhoneModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false, name="id")
	private Long id;
	
	@Column(name="number")
	private Integer number;
	
	@Column(name="citiCode")
	private Integer cityCode;
	
	@Column(name="contryCode")
	private Integer contryCode;
	
	@Column(name="idUser")
	private Long idUser;
}
