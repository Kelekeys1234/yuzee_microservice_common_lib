package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class ProcedureLocationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("location_id")
	private String id;
	
	@NotNull(message = "{procedure.location.type.is_required}") 
	@JsonProperty("type")
	private String type;

	@NotNull(message = "{procedure.location.longitude.is_required}") 
	@JsonProperty("longitude")
	private Double longitude;
	
	@NotNull(message = "{procedure.location.latitude.is_required}") 
	@JsonProperty("latitude")
	private Double latitude;
	
	@NotBlank(message = "{procedure.location.city.is_required}") 
	@JsonProperty("city")
	private String city;
	
	@NotBlank(message = "{procedure.location.state.is_required}") 
	@JsonProperty("state")
	private String state;
	
	@NotBlank(message = "{procedure.location.country.is_required}") 
	@JsonProperty("country")
	private String country;
	
	@NotBlank(message = "{procedure.location.address.is_required}") 
	@JsonProperty("address")
	private String address;

}
