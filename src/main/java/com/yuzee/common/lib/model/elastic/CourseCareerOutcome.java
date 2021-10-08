package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseCareerOutcome implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_career_outcome_id")
	@Field("course_career_outcome_id")
	private String id;

	@JsonProperty(value = "career")
	@Field(value = "career")
	private Career career;
}
