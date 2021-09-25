package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_subject_id")
	@Field("course_subject_id")
	private String id;

	@JsonProperty(value = "semester")
	@Field(value = "semester")
	private String semester;

	@NotEmpty(message = "name must not be empty")
	@JsonProperty("name")
	@Field("name")
	private String name;
	
	@JsonProperty("description")
	@Field("description")
	private String description;
}
