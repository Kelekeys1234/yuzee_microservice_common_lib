package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureStepPropertyPayment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("option")
	private String option;
	
	@JsonProperty("details")
	private String details;
}
