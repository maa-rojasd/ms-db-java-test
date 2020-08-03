package com.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PHONE")
public class PhoneModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = true, name="phoneid", unique= true)
	private Long id;
	
	@NotNull
	@Column(name="number")
	private Integer number;
	
	@NotNull
	@Column(name="citiCode")
	private Integer cityCode;
	
	@NotNull
	@Column(name="contryCode")
	private Integer contryCode;
	
	@NotNull
	@Column(name="idUser")
	private Long idUser;
}
