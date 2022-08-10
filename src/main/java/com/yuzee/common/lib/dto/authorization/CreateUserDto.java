package com.yuzee.common.lib.dto.authorization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateUserDto implements Serializable {

	/**
	 *
	 */
	
	private static final long serialVersionUID = 3262142846479885854L;
	
	@JsonProperty("password")
	private String password;
		
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("middleName")
	private String middleName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty(value = "roles")
	private List<RoleDto> roles=new ArrayList<>();
	
	public CreateUserDto() {

	}
}
