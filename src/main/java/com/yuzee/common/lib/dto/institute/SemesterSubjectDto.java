package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterSubjectDto {

	@JsonProperty("id")
	private String id;

	@NotEmpty(message = "name must not be empty")
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
}
