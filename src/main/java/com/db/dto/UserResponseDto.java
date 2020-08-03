package com.db.dto;

import java.io.Serializable;
import java.util.UUID;

import com.db.model.UserModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	
	private UserModel user;
	private UUID uuid;

}
