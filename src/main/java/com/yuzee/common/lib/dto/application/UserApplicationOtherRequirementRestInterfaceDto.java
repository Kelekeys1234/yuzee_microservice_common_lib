package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationOtherRequirementRestInterfaceDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("other_requirement_id")
	private UUID _id;
	
	@NotBlank(message = "{user_application.other_requirement.requirement_type.is_required}") 
	@JsonProperty("requirement_type")
	private String requirementType;
	
	@JsonProperty("requirement_properties")
	private Map<String, Object> properties = null;

}
