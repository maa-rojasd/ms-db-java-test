package com.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name="USER")
public class UserModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false, name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ElementCollection(targetClass=PhoneModel.class)
	@Column(name="phone")
	private List<PhoneModel> phones;
	
	@CreatedDate
	@Column(name="created")
	private Date created;
	
	@LastModifiedDate
	@Column(name="modified")
	private Date modified;
	
	@LastModifiedDate
	@Column(name="last_login")
	private Date lastLogin;
	
	@Column(name="token")
	private String token;
	
	@Column(name="isActive",columnDefinition = "boolean default true")
	private Boolean isActive;
	
}
