package com.yuzee.common.lib.dto.authorization;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("scopes")
	private Set<String> scopes;
}
