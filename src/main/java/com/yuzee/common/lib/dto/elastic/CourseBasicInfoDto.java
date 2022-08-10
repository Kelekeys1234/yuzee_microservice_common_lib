package com.yuzee.common.lib.dto.elastic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseBasicInfoDto {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("institute_id")
	private String instituteId;

	public CourseBasicInfoDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
