package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationRejectedDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("rejection_id")
	private String rejectionId;
	
	@NotBlank(message = "{user_application.rejected_application.rejection_type.is_required}") 
	@JsonProperty("rejection_type")
	private String rejectionType;
	
	@NotNull(message = "{user_application.rejected_application.description.is_required}") 
	@JsonProperty("description")
	private String description;
}
