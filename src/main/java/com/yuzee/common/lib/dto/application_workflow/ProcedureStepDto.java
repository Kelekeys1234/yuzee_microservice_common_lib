package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureStepDto implements Serializable {

	private static final long serialVersionUID = -2456408644674507740L;
	
	@JsonProperty("procedure_step_id")
	private String id;
	
	@NotBlank(message = "{procedure.procedure_step.step.is_required}") 
	@JsonProperty("step")
	private String step;
	
	@NotNull(message = "{procedure.procedure_step.order.is_required}") 
	@Min(value = 1, message = "{procedure.procedure_step.order.order_must_be_greater_than_zero}")
	@JsonProperty("step_order")
	private int stepOrder;
	
	@Valid
	@NotNull(message = "{procedure.procedure_step.propeties.is_required}") 
	@JsonProperty("properties")
	private List<ProcedureStepPropertyDto> propeties;
	
	@JsonProperty("status")
	private boolean status;
	
}
