package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationOtherRequirementDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("other_requirement_id")
	private String id;
	
	@NotBlank(message = "{user_application.other_requirement.requirement_type.is_required}") 
	@JsonProperty("requirement_type")
	private String requirementType;
	
	@Valid
	@NotNull(message = "{user_application.other_requirement.requiremet_properties.is_required}") 
	@JsonProperty("requirement_properties")
	private List<UserApplicationOtherRequirementPropertyDto> properties;

}
