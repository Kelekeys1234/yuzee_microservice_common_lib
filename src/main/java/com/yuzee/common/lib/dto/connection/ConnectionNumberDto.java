package com.yuzee.common.lib.dto.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ConnectionNumberDto {

	@JsonProperty("connection_number")
	private long connectionNumber;
	
}
