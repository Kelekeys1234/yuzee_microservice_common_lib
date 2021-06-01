package com.yuzee.common.lib.dto.elastic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserExtenededContactElasticDto {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("contact_extended_type")
	private String contactExtendedType;

	@JsonProperty("contact_extended_value")
	private String contactExtendedValue;
	
	@JsonProperty("contact_extended_option")
	private String contactExtendedOption;

}
