package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureIntakeWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{procudure.intake.type.is_required}") 
	@JsonProperty("type")
	private String type;
	
	@Valid
	@NotNull(message = "{procudure.intakes.is_required}") 
	@JsonProperty("intakes")
	private List<ProcedureIntakeDto> procedureIntakes;
	
	@JsonProperty("institute_intakes")
	private List<String> InstituteIntakes;
	
}
