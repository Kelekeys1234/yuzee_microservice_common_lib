package com.yuzee.common.lib.dto.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAccessToken implements Serializable {

	private static final long serialVersionUID = 3262142846479885854L;

	private String id;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("email")
	private String email;
}