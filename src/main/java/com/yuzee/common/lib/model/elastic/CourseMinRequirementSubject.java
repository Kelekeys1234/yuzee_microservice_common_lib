package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseMinRequirementSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_min_requirement_subject_id")
	@Field("course_min_requirement_subject_id")
	private String id;

	@JsonProperty("name")
	@Field("name")
	@NotEmpty(message = "name must not be empty")
	private String name;

	@JsonProperty("grade")
	@Field("grade")
	@NotEmpty(message = "grade must not be empty")
	private String grade;
}