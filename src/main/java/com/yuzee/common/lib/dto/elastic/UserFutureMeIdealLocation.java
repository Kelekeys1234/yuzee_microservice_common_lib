package com.yuzee.common.lib.dto.elastic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFutureMeIdealLocation {
	
	@JsonProperty("ideal_city")
	private String idealCity;
	
	@JsonProperty("ideal_country")
	private String idealCountry;

}
