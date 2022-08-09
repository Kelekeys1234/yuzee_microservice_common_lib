package com.yuzee.common.lib.dto.authorization;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResourceDto {
	
	@NotBlank(message = "name should not be empty or null")
	@JsonProperty("name")
	private String name;
	
	
	@NotNull(message = "uris should not be null")
	@JsonProperty("uris")
	private Set<String> uris;
	
	@NotNull(message = "roles shoud not be null")
	@JsonProperty("scopes")
	private Set<String> scopes;
}
