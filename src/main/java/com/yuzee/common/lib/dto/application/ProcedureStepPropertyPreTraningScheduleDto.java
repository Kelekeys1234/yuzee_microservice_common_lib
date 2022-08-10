package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class ProcedureStepPropertyPreTraningScheduleDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("day_of_the_week")
	private String dayOfTheWeek;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@JsonProperty("start_time")
	private Date startTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@JsonProperty("end_time")
	private Date endTime;
	
}
