package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


public class CoursePreRequisiteDto {

	@NotEmpty(message = "description must not be empty")
	@JsonProperty("description")
	private String description;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
