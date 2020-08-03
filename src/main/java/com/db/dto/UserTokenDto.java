package com.db.dto;

import java.io.Serializable;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a dto class to hold json web token information
 *
 * @see java.lang.Object
 * @author Marcelo Rojas
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6603576309432444760L;
	
	/**
	 * User of JWT
	 */
	private String user;
	
	/**
	 * token of JWT
	 */
	private String token;
}
