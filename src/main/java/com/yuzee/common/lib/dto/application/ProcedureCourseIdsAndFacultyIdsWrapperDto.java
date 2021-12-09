package com.yuzee.common.lib.dto.application;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureCourseIdsAndFacultyIdsWrapperDto {
	
	@Valid
	@NotNull(message = "{procedure.courses.is_required}")  
	@JsonProperty("courses")
	private List <CourseIdDto> courseIds;
	
	@Valid
	@NotNull(message = "{procedure.faculties.is_required}") 
	@JsonProperty("faculties")
	private List <FacultyIdDto> facultyIds;
	
	
}
