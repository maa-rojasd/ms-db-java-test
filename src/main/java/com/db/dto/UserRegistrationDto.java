package com.db.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.db.util.PatternConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto extends UserDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6603576309432444760L;
	
	@JsonProperty(value = "name", index = 1)
	@NotBlank
	@NotEmpty(message = "type cannot be empty")
	@Size(min = 3, max = 30, message = "type Must be between 3 and 30 characters")
	@Pattern(regexp = PatternConstants.ONLY_LETTERS, message = "type must only contain letters")
	private String name;
	@JsonProperty(value = "phones", index = 4)
	@NotEmpty(message = "type cannot be empty")
	private List<PhoneDto> phones;
	
	@Builder
	public UserRegistrationDto(String email, String password, String name, List<PhoneDto> phones) {
		super(email, password);
		this.name = name;
		this.phones = phones;
	}
	
	@Builder
	public UserRegistrationDto() {
		
	}

	public static class UserRegistrationDtoBuilder extends UserDtoBuilder {
		UserRegistrationDtoBuilder() {
			super();
		}
	}
}
