package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class LocationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("location_id")
	private String id;

	@NotNull(message = "{location.longitude.is_required}") 
	@JsonProperty("longitude")
	private Double longitude;
	
	@NotNull(message = "{location.latitude.is_required}") 
	@JsonProperty("latitude")
	private Double latitude;
	
	@NotBlank(message = "{location.city.is_required}") 
	@JsonProperty("city")
	private String city;
	
	@NotBlank(message = "{location.state.is_required}") 
	@JsonProperty("state")
	private String state;
	
	@NotBlank(message = "{location.country.is_required}") 
	@JsonProperty("country")
	private String country;

}
