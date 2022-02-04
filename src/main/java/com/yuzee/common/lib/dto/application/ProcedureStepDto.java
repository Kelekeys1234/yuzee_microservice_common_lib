package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcedureStepDto implements Serializable {

	private static final long serialVersionUID = -2456408644674507740L;
	
	@JsonProperty("procedure_step_id")
	private UUID _id;
	
	@NotBlank(message = "{procedure.procedure_step.step.is_required}") 
	@JsonProperty("step")
	private String step;
	
	@JsonProperty(value = "step_display_name", access = Access.READ_ONLY)
	private String stepDisplayName;
	
	@NotNull(message = "{procedure.procedure_step.order.is_required}") 
	@Min(value = 1, message = "{procedure.procedure_step.order.order_must_be_greater_than_zero}")
	@JsonProperty("step_order")
	private int stepOrder;
	
	@Valid
	@NotNull(message = "{procedure.procedure_step.propeties.is_required}") 
	@JsonProperty("properties")
	private List<ProcedureStepPropertyDto> propeties = new ArrayList<>();
	
	@JsonProperty(value = "status", access = Access.READ_ONLY)
	private boolean status;
	
}
