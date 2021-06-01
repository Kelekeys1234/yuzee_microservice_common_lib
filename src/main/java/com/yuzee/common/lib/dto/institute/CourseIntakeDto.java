package com.yuzee.common.lib.dto.institute;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseIntakeDto {

	@JsonProperty("course_intake_id")
	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "intake_date")
	@NotNull(message = "intake_date must not be null")
	private Date intakeDate;
}
