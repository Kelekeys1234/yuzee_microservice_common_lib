package com.yuzee.common.lib.dto.workflow;

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
	private String procedureStepId;
	
	@NotBlank(message = "{procedure.procedure_stpes.procedure_status_type.is_required}") 
	@JsonProperty("procedure_status_type")
	private String procedureStatusType;
	
	@NotNull(message = "{procedure.procedure_stpes.order.is_required}") 
	@Min(value = 1, message = "{procedure.procedure_stpes.order.order_must_be_greater_than_zero}")
	@JsonProperty("step_order")
	private int stepOrder;
	
	@Valid
	@NotNull(message = "{procedure.procedure_stpes.procedure_step_properties.is_required}") 
	@JsonProperty("procedure_step_properties")
	private List<ProcedureStepPropetiesDto> procedureStepPropeties;
	
}
