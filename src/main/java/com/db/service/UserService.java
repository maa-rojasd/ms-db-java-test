package com.db.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.db.dto.ResponseObject;
import com.db.dto.UserDto;
import com.db.dto.UserRegistrationDto;

public interface UserService {
	public ResponseEntity<ResponseObject> createUser(UserRegistrationDto userDto, String token);
	
	public ResponseEntity<ResponseObject> updateUser(UserRegistrationDto userDto, String token);
	
	public ResponseEntity<ResponseObject> loginUser(UserDto userDto);
	
	public String getJWTToken(String username);
	

}
