package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSemesterDto {
	@NotEmpty(message = "courseSemesterDtoId must not be empty")
	@JsonProperty("courseSemesterDtoId")
    private String courseSemesterDtoId;
	@NotEmpty(message = "type must not be empty")
	@JsonProperty("type")
	private String type;

	@NotEmpty(message = "name must not be empty")
	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("subjects")
	ValidList<SemesterSubjectDto> subjects;
}
