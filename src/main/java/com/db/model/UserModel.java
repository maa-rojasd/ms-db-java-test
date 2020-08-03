package com.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(nullable = false, name="idUser", unique = true, updatable=false)
	private Long id;
	
	@NotNull
	@Column(name="name", updatable=false)
	private String name;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
    @Column(name = "phone")
	private List<PhoneModel> phones;
	
	@NotNull
	@CreatedDate
	@Column(name="created", updatable=false)
	private Date created;
	
	@NotNull
	@LastModifiedDate
	@Column(name="modified")
	private Date modified;
	
	@NotNull
	@LastModifiedDate
	@Column(name="last_login")
	private Date lastLogin;
	
	@NotNull
	@Column(name="token",columnDefinition="LONGTEXT")
	private String token;
	
	@NotNull
	@Column(name="isActive",columnDefinition = "boolean default true")
	private Boolean isActive;
	
}
