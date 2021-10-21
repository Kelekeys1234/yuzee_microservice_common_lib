package com.yuzee.common.lib.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDistanceWillingToTravelDto {
	
	@JsonProperty("willing_to_travel_to_job_mentioned_address")
	private boolean willingToTravelToJobMentionedAddress;
	
	@JsonProperty("user_distance_from_job")
	private double userDistanceFromJob; 
}