package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseCareerOutcomeDto {

	@JsonProperty(value = "career")
	private CareerDto career;

	public CourseCareerOutcomeDto(CareerDto career) {
		super();
		this.career = career;
	}
	
	
}
