package com.yuzee.common.lib.dto.authorization;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoleBasedPolicyDto {

	@NotBlank(message = "name should not be null or empty")
	@JsonProperty("name")
	private String name;
	
	@NotBlank(message = "role should not be null or empty")
	@JsonProperty("role")
	private String role;
}
