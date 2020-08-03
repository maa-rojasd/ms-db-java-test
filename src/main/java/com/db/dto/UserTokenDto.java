package com.db.dto;

import java.io.Serializable;



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
public class UserTokenDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6603576309432444760L;

	private String user;
	
	private String token;
}
