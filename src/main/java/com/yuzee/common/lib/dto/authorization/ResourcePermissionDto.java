package com.yuzee.common.lib.dto.authorization;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResourcePermissionDto {

	@NotBlank(message = "name should not be null or empty")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "scopes can not be null")
	@JsonProperty("scopes")
	private Set<String> scopes;
	
	@NotNull(message = "resources can not be null")
	@JsonProperty("resources")
	private Set<String> resources;
	
	@NotNull(message = "role_policies can not be null")
	@JsonProperty("policies")
	private Set<String> policies;
}
