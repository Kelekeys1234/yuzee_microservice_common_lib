package com.yuzee.common.lib.dto.job;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobWorkingHours {
	
	@JsonProperty("id")
	private String id;
	
	@NotBlank(message = "day_of_week should not be null / blank")
	@JsonProperty("day_of_week")
	private String weekDay;

	@NotNull(message = "open_at can not be null / blank")
	@JsonProperty("open_at")
	@JsonFormat(pattern = "hh:mm a")
	private Date openingAt;

	@NotNull(message = "close_at can not be null / blank")
	@JsonProperty("close_at")
	@JsonFormat(pattern = "hh:mm a")
	private Date closingAt;
}