package com.yuzee.common.lib.dto.getstream;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GetStreamDto {
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("object")
	private Object object;

}
