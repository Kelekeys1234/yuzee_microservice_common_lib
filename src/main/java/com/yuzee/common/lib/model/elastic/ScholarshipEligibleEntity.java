package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ScholarshipEligibleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7144393613822021080L;

	@JsonProperty("id")
	@Field(name = "id")
	private String id;

	@JsonProperty("entity_id")
	@Field(name = "entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	@Field(name = "entity_type")
	private String scholarshipEntityType;
}