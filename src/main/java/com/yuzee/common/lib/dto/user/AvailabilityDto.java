package com.yuzee.common.lib.dto.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AvailabilityDto {
	@JsonProperty("day_of_week")
	private String dayOfWeek;
	
	@JsonProperty("start_time")
	@JsonFormat(pattern = "h:mm a")
	private Date startTime;
	
	@JsonProperty("end_time")
	@JsonFormat(pattern = "h:mm a")
	private Date endTime;
}
