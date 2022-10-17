package com.yuzee.common.lib.dto.institute;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMinRequirementDto {

	@JsonProperty("courseMinRequirementId")
	@NotEmpty(message = "courseMinRequirement_id must not be empty")
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
	private List<CourseMinRequirementSubjectDto> minRequirementSubjects = new ArrayList<>();;

	@JsonProperty("study_languages")
	@NotNull(message = "study_languages must not be null")
	Set<String> studyLanguages;

	public CourseMinRequirementDto(String courseMinRequirementId,
			@NotEmpty(message = "country_name must not be empty") String countryName,
			@NotEmpty(message = "state_name must not be empty") String stateName,
			@NotEmpty(message = "education_system_id must not be empty") String educationSystemId,
			@NotNull(message = "grade_point must not be null") Double gradePoint,
			@Valid List<CourseMinRequirementSubjectDto> minRequirementSubjects,
			@NotNull(message = "study_languages must not be null") Set<String> studyLanguages) {
		super();
		this.id = courseMinRequirementId;
		this.countryName = countryName;
		this.stateName = stateName;
		this.educationSystemId = educationSystemId;
		this.gradePoint = gradePoint;
		this.minRequirementSubjects = minRequirementSubjects;
		this.studyLanguages = studyLanguages;
	}


	
}
