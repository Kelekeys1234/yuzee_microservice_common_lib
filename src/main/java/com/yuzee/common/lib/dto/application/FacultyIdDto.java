package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class FacultyIdDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{faculty.faculty_id.is_required}") 
	@JsonProperty("faculty_id")
	private String facultyId;
	
	@JsonProperty("name")
	private String name;
}
