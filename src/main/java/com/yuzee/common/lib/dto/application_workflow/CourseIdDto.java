package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseIdDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{course.course_id.is_required}") 
	@JsonProperty("course_id")
	private String courseId;
}
