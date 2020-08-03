package com.db.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.db.dto.ResponseObject;
import com.db.dto.UserDto;
import com.db.dto.UserRegistrationDto;
import com.db.dto.UserResponseDto;
import com.db.model.UserModel;
import com.db.repository.UserRepository;
import com.db.util.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService{
	public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final ObjectMapper objectMapper;
	private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ObjectMapper objectMapper, UserRepository userRepository) {
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
    }
    
	@Override
	public ResponseEntity<ResponseObject> createUser(UserRegistrationDto userDto, String token) {
		log.info("UserService: createUser");
		UserModel userModel = UserModel.builder().build();
		UserResponseDto userResponse = UserResponseDto.builder().build();
		ResponseObject responseObject = null;
		userModel = objectMapper.userDtoToModel(userDto, token);		
		log.info(userModel.getPhones().get(0).getCityCode().toString());
		try {
			if (userRepository.existsByEmail(userModel.getEmail())) {
				responseObject = ResponseObject.builder().status("500").message("El correo ya registrado").data("").build();
				return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			userRepository.save(userModel);
			userResponse.setUser(userModel);
			userResponse.setUuid(UUID.randomUUID());
			responseObject = ResponseObject.builder().status("200").message("Guardado exitoso").data(userResponse).build();
			return new ResponseEntity<>(responseObject, HttpStatus.OK);
		} catch (Exception e) {
			log.error("UserService: createUser Error");
			log.error(e.getMessage());
			responseObject = ResponseObject.builder().status("500").message("Guardado fallido").data("d").build();
			return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


	@Override
	public ResponseEntity<ResponseObject> loginUser(UserDto userDto) {
		log.info("UserService: LoginUser");
		ResponseObject responseObject = null;
		try {
			if(!userRepository.existsByEmailAndPassword(userDto.getEmail(), userDto.getPassword())) {
				responseObject = ResponseObject.builder().status("500").message("Login fallido usuario o password invalido").data("").build();
				return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			log.error("UserService: loginUser Error");
			log.error(e.getMessage());
			responseObject = ResponseObject.builder().status("500").message("Error al procesar LoginUser service").data("").build();
			return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		responseObject = ResponseObject.builder().status("200").message("Login exitoso").data("").build();
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<ResponseObject> updateUser(UserRegistrationDto userDto, String token) {
		log.info("UserService: updateUser");
		UserModel userModel = UserModel.builder().build();
		UserResponseDto userResponse = UserResponseDto.builder().build();
		ResponseObject responseObject = null;

		try {
			userModel = userRepository.findByEmail(userDto.getEmail());
			userModel = objectMapper.userDtoToModelUpdate(userDto, token , userModel);
			userRepository.save(userModel);
			userResponse.setUser(userModel);
			userResponse.setUuid(UUID.randomUUID());
			responseObject = ResponseObject.builder().status("200").message("Guardado exitoso").data(userResponse).build();
			return new ResponseEntity<>(responseObject, HttpStatus.OK);
		} catch (Exception e) {
			log.error("UserService: createUser Error");
			log.error(e.getMessage());
			responseObject = ResponseObject.builder().status("500").message("Guardado fallido").data("d").build();
			return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public String getJWTToken(String mail) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(mail)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		log.info(token);
		return "Bearer " + token;
	}


}
