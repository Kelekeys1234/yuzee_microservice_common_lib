package com.yuzee.common.lib.dto.institute;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.eligibility.FundingResponseDto;

import lombok.Data;

@Data
public class CourseFundingDto {


	@JsonProperty(value = "funding_name_id")
	@NotEmpty(message = "funding_name_id must not be null")
	private List<String> fundingNameId;
	
	@JsonProperty(value = "funding")
	private FundingResponseDto funding;

	public CourseFundingDto(
			@NotEmpty(message = "funding_name_id must not be null") List<String> fundingNameId) {
		super();
		this.fundingNameId = fundingNameId;
	}
	
}
