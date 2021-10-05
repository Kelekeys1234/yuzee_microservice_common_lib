package com.yuzee.common.lib.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.SystemEventDTO;

import lombok.Data;

@Data
public class DeadLetterDto {
	
	@JsonProperty("error_message")
	private String errorMessage;
	
	@JsonProperty("system_event")
	private SystemEventDTO systemEvent;
}
