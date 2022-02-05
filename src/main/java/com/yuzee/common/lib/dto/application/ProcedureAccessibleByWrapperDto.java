package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureAccessibleByWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{procudure.accesible_by_type.is_required}") 
	@JsonProperty("accessible_by_type")
	private String accessibleByType;

	@Valid
	@NotNull(message = "{procudure.accessible_by.is_required}") 
	@JsonProperty("accessible_by")
	private Set<ProcedureAccessibleByDto> procedureAccessibleBy;	
	
}
