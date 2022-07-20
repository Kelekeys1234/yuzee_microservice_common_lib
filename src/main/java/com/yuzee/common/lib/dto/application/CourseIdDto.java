package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseIdDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{course.course_id.is_required}") 
	@JsonProperty("course_id")
	private String courseId;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty(value = "procedure_id", access = Access.READ_ONLY)
	private String procedureId;
	
	@JsonProperty(value = "procedure_name", access = Access.READ_ONLY)
	private String procedureName;
}
