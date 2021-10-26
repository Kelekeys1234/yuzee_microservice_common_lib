package com.yuzee.common.lib.dto.institute;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;

import lombok.Data;

@Data
public class CourseMinRequirementDto {

	@JsonProperty("course_min_requirement_id")
	private String id;

	@JsonProperty("country_name")
	@NotEmpty(message = "country_name must not be empty")
	private String countryName;

	@JsonProperty("state_name")
	@NotEmpty(message = "state_name must not be empty")
	private String stateName;

	@JsonProperty("education_system_id")
	@NotEmpty(message = "education_system_id must not be empty")
	private String educationSystemId;
	
	@JsonProperty("education_system")
	private EducationSystemDto educationSystem;

	@JsonProperty("grade_point")
	@NotNull(message = "grade_point must not be null")
	private Double gradePoint;

	@Valid
	@JsonProperty("min_requirement_subjects")
	private ValidList<CourseMinRequirementSubjectDto> minRequirementSubjects;

	@NotNull(message = "linked_course_ids must not be null")
	@JsonProperty("linked_course_ids")
	List<String> linkedCourseIds;

	@JsonProperty("study_languages")
	@NotNull(message = "study_languages must not be null")
	Set<String> studyLanguages;
}
