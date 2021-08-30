package com.yuzee.common.lib.dto.scholarship;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScholarshipApplicationDeadlineIntake {

	@JsonProperty("intake_id")
	private String id;

	@JsonProperty("intake_key")
	private String intakeKey;

	@JsonProperty("intake_value")
	private String intakeValue;
}