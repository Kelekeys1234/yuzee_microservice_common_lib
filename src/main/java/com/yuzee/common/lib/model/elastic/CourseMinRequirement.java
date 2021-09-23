package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseMinRequirement implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_min_requirement_id")
	@Field("course_min_requirement_id")
	private String id;

	@JsonProperty("country_name")
	@Field("country_name")
	@NotEmpty(message = "country_name must not be empty")
	private String countryName;

	@JsonProperty("state_name")
	@Field("state_name")
	@NotEmpty(message = "state_name must not be empty")
	private String stateName;

	@JsonProperty("education_system_id")
	@Field("education_system_id")
	@NotEmpty(message = "education_system_id must not be empty")
	private String educationSystemId;
	
	@JsonProperty("education_system")
	@Field("education_system")
	private EducationSystem educationSystem;

	@JsonProperty("grade_point")
	@Field("grade_point")
	@NotNull(message = "grade_point must not be null")
	private Double gradePoint;

	@Valid
	@JsonProperty("min_requirement_subjects")
	@Field("min_requirement_subjects")
	@NotNull(message = "min_requirement_subjects must not be null")
	private List<CourseMinRequirementSubject> minRequirementSubjects;
}
