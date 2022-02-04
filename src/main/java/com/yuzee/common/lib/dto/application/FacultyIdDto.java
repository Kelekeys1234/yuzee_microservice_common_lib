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
public class FacultyIdDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{faculty.faculty_id.is_required}") 
	@JsonProperty("faculty_id")
	private String facultyId;
	
	@JsonProperty(value = "name", access = Access.READ_ONLY)
	private String name;
}
