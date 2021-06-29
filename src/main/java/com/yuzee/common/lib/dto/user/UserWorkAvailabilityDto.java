package com.yuzee.common.lib.dto.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWorkAvailabilityDto {

	@NotBlank(message = "privacy_level is required")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@NotNull(message = "looking_for_work is required")
	@JsonProperty("looking_for_work")
	private boolean lookingForWork;
	
	@NotBlank(message = "work_type is required")
	@JsonProperty("preferred_work_type")
	private String preferredWorkType;
	
	@DecimalMin(value = "0.0", message = "distance is required") 
	@JsonProperty("distance")
	private double distance;
	
	@NotBlank(message = "work_status is required")
	@JsonProperty("work_status")
	private String workStatus;
	
	@JsonProperty("work_availablity")
	private List<AvailabilityDto> workAvailablity = new ArrayList<>();
}
