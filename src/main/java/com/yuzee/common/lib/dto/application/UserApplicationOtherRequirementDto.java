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
	
	@NotBlank(message = "{user_application.other_requirement.requirement.is_required}") 
	@JsonProperty("requirement")
	private String requirement;
	
	@NotNull(message = "{user_application.other_requirement.order.is_required}") 
	@Min(value = 1, message = "{user_application.other_requirement.order.order_must_be_greater_than_zero}")
	@JsonProperty("order")
	private int requirementOrder;
	
	@Valid
	@NotNull(message = "{user_application.other_requirement.requiremet_properties.is_required}") 
	@JsonProperty("requirement_properties")
	private List<UserApplicationOtherRequirementPropertyDto> properties;

}
