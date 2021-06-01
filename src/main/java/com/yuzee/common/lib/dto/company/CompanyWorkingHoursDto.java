package com.yuzee.common.lib.dto.company;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyWorkingHoursDto {
	
	@JsonProperty("working_hour_id")
	private String workingHourId;
	
	@NotBlank(message = "day_of_week should not be null / blank")
	@JsonProperty("day_of_week")
	private String dayOfWeek;
	
	@NotNull(message = "day_of_week should not be null / blank")
	@JsonProperty("is_off_day")
	public Boolean isOffDay;
	
	@NotBlank(message = "open_at should not be null / blank")
	@JsonProperty("open_at")
	@JsonFormat(pattern = "hh:mm a")
	private Date openAt;
	
	@NotBlank(message = "close_at should not be null / blank")
	@JsonProperty("close_at")
	@JsonFormat(pattern = "hh:mm a")
	private Date closeAt;
}
