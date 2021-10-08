package com.yuzee.common.lib.dto.institute;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DayTimingDto {
	
	@JsonProperty("opening_from")
	private String openingFrom;
	
	@JsonProperty("opening_to")
	private String openingTo;
	
	@JsonProperty("day")
	private String day;
}
