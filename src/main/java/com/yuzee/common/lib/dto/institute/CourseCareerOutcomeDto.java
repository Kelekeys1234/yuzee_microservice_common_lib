package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseCareerOutcomeDto {

	@JsonProperty(value = "career")
	private CareerDto career;
}
