package com.yuzee.common.lib.dto.eligibility;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EligibilityOutcomeExistsDto {

	@JsonProperty("outcome_exists")
	private boolean outcomeExists;
}
