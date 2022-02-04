package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcedureStepRestInterfaceDto implements Serializable {
	
	private static final long serialVersionUID = 1440705032386565929L;

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
	
	@JsonProperty("properties")
	private Map<String, Object> properties = new HashMap<>();
	
	@JsonProperty(value = "status", access = Access.READ_ONLY)
	private boolean status;
	
}
