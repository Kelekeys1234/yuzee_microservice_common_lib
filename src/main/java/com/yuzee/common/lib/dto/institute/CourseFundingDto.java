package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.eligibility.FundingResponseDto;

import lombok.Data;

@Data
public class CourseFundingDto {

	@JsonProperty("course_funding_id")
	private String id;

	@JsonProperty(value = "funding_name_id")
	@NotEmpty(message = "funding_name_id must not be null")
	private String fundingNameId;
	
	@JsonProperty(value = "funding")
	private FundingResponseDto funding;
}
