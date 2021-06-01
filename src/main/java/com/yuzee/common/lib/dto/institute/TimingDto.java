package com.yuzee.common.lib.dto.institute;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TimingDto {
	
	@JsonProperty("timing_id")
	private String id;

	@JsonProperty("monday")
	private String monday;

	@JsonProperty("tuesday")
	private String tuesday;

	@JsonProperty("wednesday")
	private String wednesday;

	@JsonProperty("thursday")
	private String thursday;

	@JsonProperty("friday")
	private String friday;

	@JsonProperty("saturday")
	private String saturday;

	@JsonProperty("sunday")
	private String sunday;

	@JsonProperty("timing_type")
	private String timingType;

	@JsonProperty("entity_type")
	private String entityType;

	@JsonProperty("entity_id")
	private String entityId;
}
