package com.yuzee.common.lib.dto.workflow;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureStepPropetiesDto implements Serializable {

	private static final long serialVersionUID = -2456408644674507740L;
	
	@JsonProperty("property_id")
	private String propertyId;
	
	@NotBlank(message = "{procedure.procedure_stpes.property.property_type.is_required}") 
	@JsonProperty("property_type")
	private String propertyType;
	
	@NotBlank(message = "{procedure.procedure_stpes.property.property_value.is_required}") 
	@JsonProperty("property_value")
	private String propertyValue;
}
