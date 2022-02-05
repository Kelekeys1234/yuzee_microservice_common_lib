package com.yuzee.common.lib.dto.application;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureCourseIdsAndFacultyIdsWrapperDto {
	
	@Valid
	@NotNull(message = "{procedure.courses.is_required}")  
	@JsonProperty("courses")
	private Set <CourseIdDto> courseIds;
	
	@Valid
	@NotNull(message = "{procedure.faculties.is_required}") 
	@JsonProperty("faculties")
	private Set <FacultyIdDto> facultyIds;
	
	
}
