package com.yuzee.common.lib.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReadableIdExistsDto {
	@JsonProperty("alredy_exists")
	private boolean alreadyExists;
}
