package com.db.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.dto.ResponseObject;
import com.db.dto.UserDto;
import com.db.dto.UserRegistrationDto;
import com.db.dto.UserTokenDto;
import com.db.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/V1")
public class UserController {
	
	public static final Logger log  =  LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping(value = "/Registro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseObject> setRegistration (@RequestBody @Valid UserRegistrationDto userDto,
    		@RequestHeader(value = "Authorization") String authToken)  {
		log.info("POST: Registro: {}", userDto.getEmail().toString());
		
		return userService.createUser(userDto, authToken);
			
	}	
	
	@PostMapping(value = "/Login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseObject> login (@RequestBody @Valid UserDto userDto,
    		@RequestHeader(value = "Authorization") String authToken)  {
		log.info("POST: Login: {}", userDto.getEmail().toString());
		return userService.loginUser(userDto);
			
	}
	
	@PutMapping(value = "/UpdateRegistro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseObject> updateRegistration (@RequestBody @Valid UserRegistrationDto userDto,
    		@RequestHeader(value = "Authorization") String authToken)  {
			
		return userService.updateUser(userDto, authToken);
			
	}
	
	@PostMapping(value ="/UserToken", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserTokenDto login(@RequestBody @Valid UserDto userDto) {
		log.info("POST: Login: {}", userDto.getEmail());
		String token = userService.getJWTToken(userDto.getEmail());
		UserTokenDto user = UserTokenDto.builder().build();
		user.setUser(userDto.getEmail());
		user.setToken(token);		
		return user;
		
	}
}
