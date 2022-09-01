package com.yuzee.common.lib.dto.accessibility;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoleEntityDto {
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("entity_type")
	private String entityType;
	
	@JsonProperty("entity_roles")
	private List<String> roles;
	
}