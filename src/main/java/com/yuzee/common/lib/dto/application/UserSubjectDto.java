package com.yuzee.common.lib.dto.application;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserSubjectDto {
	@JsonProperty("subject_id")
	private String id;
	
	@NotBlank(message = "subject_name should not be blank")
	@JsonProperty("subject_name")
	private String subjectName;
	
	@NotBlank(message = "grade is required") 
	@JsonProperty("grade")
	private String grade;
}
