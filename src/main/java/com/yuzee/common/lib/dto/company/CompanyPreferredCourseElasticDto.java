package com.yuzee.common.lib.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPreferredCourseElasticDto {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("course_name")
	private String courseName;
		
	@JsonProperty("course_id")
	private String courseId;
}