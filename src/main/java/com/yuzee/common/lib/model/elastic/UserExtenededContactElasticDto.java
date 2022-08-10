package com.yuzee.common.lib.model.elastic;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserExtenededContactElasticDto {
	
	@Field(name = "id")
	@JsonProperty("id")
	private String id;

	@Field(name = "contact_extended_type")
	@JsonProperty("contact_extended_type")
	private String contactExtendedType;

	@Field(name = "contact_extended_value")
	@JsonProperty("contact_extended_value")
	private String contactExtendedValue;
	
	@Field(name = "contact_extended_option")
	@JsonProperty("contact_extended_option")
	private String contactExtendedOption;

}
