package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserStudyTimeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("day_of_the_week")
	private String dayOfTheWeek;
	
	@JsonProperty("time_of_the_day")
	private String timeOfTheDay;
}
