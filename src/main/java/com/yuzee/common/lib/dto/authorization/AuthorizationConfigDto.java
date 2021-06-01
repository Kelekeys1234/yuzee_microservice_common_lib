package com.yuzee.common.lib.dto.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.GenericRequestWrapper;

import lombok.Data;

@Data
public class AuthorizationConfigDto {
	
	@JsonProperty("scopes")
	private GenericRequestWrapper<ScopeDto> scopes;
	
	@JsonProperty("role-based-policy")
	private GenericRequestWrapper<RoleBasedPolicyDto> roleBasedPolicies;
	
	@JsonProperty("resources")
	private GenericRequestWrapper<ResourceDto> resources;
	
	@JsonProperty("permissions")
	private GenericRequestWrapper<ResourcePermissionDto> permissions;
}
