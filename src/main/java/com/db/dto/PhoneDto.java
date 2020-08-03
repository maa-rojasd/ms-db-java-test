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
 * This is a dto class to hold phone information
 *
 * @see java.lang.Object
 * @author Marcelo Rojas
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6052847025057197685L;
	
	/**
	 * Phone number 
	 */
	@JsonProperty(value="number",index=1)
	@NotEmpty (message = "validator cannot be empty")
	@Size(min=9, max=11, message = "number Must be between 9 and 11 characters")
    @Pattern(regexp = PatternConstants.ONLY_NUMBERS, message = "number Must only contain numbers")
	private Integer number;
	
	/**
	 * City code of phone
	 */
	@JsonProperty(value="citycode",index=2)
	@NotEmpty (message = "validator cannot be empty")
	@Size(min=1, max=15, message = "number Must be between 1 and 15 characters")
    @Pattern(regexp = PatternConstants.ONLY_NUMBERS, message = "number Must only contain numbers")
	private Integer cityCode;
	
	/**
	 * Country code of phone
	 */
	@JsonProperty(value="contrycode",index=3)
	@NotEmpty (message = "validator cannot be empty")
	@Size(min=1, max=15, message = "number Must be between 1 and 15 characters")
    @Pattern(regexp = PatternConstants.ONLY_NUMBERS, message = "number Must only contain numbers")
	private Integer contryCode;
}
