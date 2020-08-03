package com.db.dto;

import java.io.Serializable;
import java.util.UUID;

import com.db.model.UserModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a response class to hold user information
 *
 * @see java.lang.Object
 * @author Marcelo Rojas
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3227217036622279011L;

	/**
	 * Object of user, contains especific information
	 */
	private UserModel user;
	/**
	 * UUID of user
	 */
	private UUID uuid;

}
