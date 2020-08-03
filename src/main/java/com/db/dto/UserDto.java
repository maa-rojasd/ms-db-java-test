package com.db.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.db.util.PatternConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a dto class to hold user information
 *
 * @see java.lang.Object
 * @author Marcelo Rojas
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6603576309432444760L;
	
	/**
	 * Email of user
	 */
	@JsonProperty(value="email",index=2)
	@NotEmpty(message = "type cannot be empty")
    @Size(min=8, max=30, message = "type Must be between 8 and 30 characters")
    @Pattern(regexp = PatternConstants.MAIL_VALID , message = "type must only contain letters and numbers")
	private String email;
	
	/**
	 * Password of user
	 */
	@JsonProperty(value="password",index=3)
	@NotEmpty(message = "type cannot be empty")
    @Size(min=8, max=30, message = "type Must be between 8 and 30 characters")
    @Pattern(regexp = PatternConstants.PASSWORD_VALID , message = "type must only contain minimum 2 numbers 1 upper case letter 1 lower case letter")
	private String password;
}
