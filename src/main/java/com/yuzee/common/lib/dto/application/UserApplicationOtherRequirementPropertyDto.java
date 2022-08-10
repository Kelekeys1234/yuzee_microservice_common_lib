package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class UserApplicationOtherRequirementPropertyDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{user_application.other_requirement.property.property_type.is_required}") 
	@JsonProperty("property_type")
	private String propertyType;
	
	@JsonProperty("property_value")
	private UserApplicationOtherRequirementPropertyValueWrapperDto userApplicationOtherRequirementPropertyValueWrapperDto;
}
