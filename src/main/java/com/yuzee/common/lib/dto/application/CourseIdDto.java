package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseIdDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{course.course_id.is_required}") 
	@JsonProperty("course_id")
	private String courseId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("procedure_id")
	private String procedureId;
	
	@JsonProperty("procedure_name")
	private String procedureName;
}
