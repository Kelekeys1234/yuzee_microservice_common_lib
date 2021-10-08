package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EnableApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private String id;
	
	@NotBlank(message = "{enable_applicaiton.entity_id.is_required}") 
	@JsonProperty("entity_id")
	private String entityId;
	
	@NotBlank(message = "{enable_applicaiton.entity_type.is_required}") 
	@JsonProperty("entity_type")
	private String entityType;
	
	@NotBlank(message = "{enable_applicaiton.student_type.is_required}")
	@JsonProperty("student_type")
	private String studentType;
	
	@JsonProperty("is_enable")
	private boolean isEnable;

	
}
