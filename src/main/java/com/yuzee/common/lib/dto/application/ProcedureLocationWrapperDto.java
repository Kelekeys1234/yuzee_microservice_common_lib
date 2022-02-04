package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProcedureLocationWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("is_for_all_locations")
	private boolean isForAllLocations ;	
	
	@Valid
	@NotNull(message = "{procudure.locations.is_required}") 
	@JsonProperty("locations")
	private List<ProcedureLocationDto> procedureLocations;
	
	@JsonProperty(value = "off_campus_location")
	private List<ProcedureLocationDto> procedureOffCampusLocationsDto;
	
	@JsonProperty(value = "on_campus_location")
	private List<ProcedureLocationDto> procedureOnCampusLocationsDto;
}
