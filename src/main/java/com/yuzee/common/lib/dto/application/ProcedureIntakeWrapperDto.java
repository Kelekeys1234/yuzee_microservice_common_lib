package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcedureIntakeWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{procudure.intake.type.is_required}") 
	@JsonProperty("type")
	private String type;
	
	@Valid
	@NotNull(message = "{procudure.intakes.is_required}") 
	@JsonProperty("intakes")
	private Set<ProcedureIntakeDto> procedureIntakes;
	
	@JsonProperty(value = "institute_intakes", access = Access.READ_ONLY)
	private List<String> instituteIntakes;
	
}
