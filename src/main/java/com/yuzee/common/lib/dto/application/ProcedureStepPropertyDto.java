package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureStepPropertyDto implements Serializable {

	private static final long serialVersionUID = -2456408644674507740L;
	
	@JsonProperty("property_id")
	private String id;
	
	@NotBlank(message = "{procedure.procedure_step_property.property_type.is_required}") 
	@JsonProperty("property_type")
	private String propertyType;
	
	@JsonProperty("property_value")
	private ProcedureStepPropertyValueWrapperDto propertyValue;
	
}
