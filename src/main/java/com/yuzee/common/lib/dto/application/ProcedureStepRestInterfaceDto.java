package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureStepRestInterfaceDto implements Serializable {
	
	private static final long serialVersionUID = 1440705032386565929L;

	@JsonProperty("procedure_step_id")
	private String id;
	
	@NotBlank(message = "{procedure.procedure_step.step.is_required}") 
	@JsonProperty("step")
	private String step;
	
	@JsonProperty("step_display_name")
	private String stepDisplayName;
	
	@NotNull(message = "{procedure.procedure_step.order.is_required}") 
	@Min(value = 1, message = "{procedure.procedure_step.order.order_must_be_greater_than_zero}")
	@JsonProperty("step_order")
	private int stepOrder;
	
	@JsonProperty("properties")
	private Map<String, Object> properties = new HashMap<>();
	
	@JsonProperty("status")
	private boolean status;
	
}
