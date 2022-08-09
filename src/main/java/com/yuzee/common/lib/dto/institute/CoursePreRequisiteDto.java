package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CoursePreRequisiteDto {

	@JsonProperty("course_pre_requisite_id")
	private String id;

	@NotEmpty(message = "description must not be empty")
	@JsonProperty("description")
	private String description;

}
