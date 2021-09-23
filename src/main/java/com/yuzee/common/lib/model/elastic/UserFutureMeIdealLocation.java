package com.yuzee.common.lib.model.elastic;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFutureMeIdealLocation {
	
	@Field(name = "ideal_city")
	@JsonProperty("ideal_city")
	private String idealCity;
	
	@Field(name = "ideal_country")
	@JsonProperty("ideal_country")
	private String idealCountry;

}
