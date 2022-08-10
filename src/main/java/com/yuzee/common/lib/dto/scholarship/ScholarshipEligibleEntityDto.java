package com.yuzee.common.lib.dto.scholarship;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ScholarshipEligibleEntityDto {
	@JsonProperty("id")
	private String id;

	@JsonProperty("entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	private String scholarshipEntityType;
}