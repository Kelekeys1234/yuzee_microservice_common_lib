package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureStepPropertyPayment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("option")
	private String option;
	
	@JsonProperty("details")
	private String details;
}
