package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPartner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7364630144212162677L;

	@JsonProperty("id")
	@Field(name = "id")
	private String id;

	@JsonProperty("entity_id")
	@Field(name = "entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	@Field(name = "entity_type")
	private String entityType;
}