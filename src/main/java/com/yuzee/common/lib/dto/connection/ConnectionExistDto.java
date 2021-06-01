package com.yuzee.common.lib.dto.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionExistDto {

	@JsonProperty("connection_exist")
	private boolean connectionExist;
	
	@JsonProperty("is_owner_entity")
	private Boolean isOwnerEntity;
	
	@JsonProperty("connection_status")
	private String connectionStatus;
}