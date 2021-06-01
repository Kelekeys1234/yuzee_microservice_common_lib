package com.yuzee.common.lib.dto.institute;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseScholarshipElasticDto {

	@JsonProperty("course_scholarship_id")
	private String id;

	@JsonProperty(value = "scholarship")
	private ScholarshipElasticDto scholarship;
}
