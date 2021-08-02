package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class UserApplicationOtherRequirementPropertyDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("other_requirement_property_id")
	private String id;
	
	@NotBlank(message = "{user_application.other_requirement.property.property_type.is_required}") 
	@JsonProperty("property_type")
	private String propertyType;
	
	@NotBlank(message = "{user_application.other_requirement.property.property_value.is_required}") 
	@JsonProperty("property_value")
	private String propertyValue;
	
	@JsonProperty("attachment")
	private StorageDto attachment;
}
