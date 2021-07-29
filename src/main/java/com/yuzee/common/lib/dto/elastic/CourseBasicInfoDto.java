package com.yuzee.common.lib.dto.elastic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseBasicInfoDto {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;
}
