package com.yuzee.common.lib.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityPrivacyInfoDto {
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("entity_name")
	private String entityName;

	@JsonProperty("entity_description")
	private String entityDescription;
}
