package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationRejectedDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private UUID _id;
	
	@NotBlank(message = "{user_application.rejected_application.rejection_type.is_required}") 
	@JsonProperty("rejection_type")
	private String rejectionType;
	
	@NotNull(message = "{user_application.rejected_application.description.is_required}") 
	@JsonProperty("description")
	private String description;
}
