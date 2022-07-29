package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserStudyTimeDto implements Serializable {
	
	@JsonProperty("study_time_id")
	private String id;
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("day_of_the_week")
	private String dayOfTheWeek;
	
	@JsonProperty("time_of_the_day")
	private String timeOfTheDay;
}