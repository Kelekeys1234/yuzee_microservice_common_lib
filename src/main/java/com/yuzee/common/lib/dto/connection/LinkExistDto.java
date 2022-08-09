package com.yuzee.common.lib.dto.connection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkExistDto {
	
	@JsonProperty("link_exist")
	private boolean linkExist;

}
