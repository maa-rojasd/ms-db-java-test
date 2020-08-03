package com.db.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResponseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1163887803993526752L;

	/**
	 * Status of response
	 */
	@JsonProperty("status")
	private String status;

	/**
	 * Message detail of response
	 */
	@JsonProperty("message")
	private String message;
	
	/**
	 * Object with the data
	 */
	@JsonProperty("data")
	private Object data;
}
