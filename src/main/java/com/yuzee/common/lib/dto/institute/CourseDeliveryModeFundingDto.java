package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.eligibility.FundingResponseDto;

import lombok.Data;

@Data
public class CourseDeliveryModeFundingDto {

	@JsonProperty("id")
	private String id;

	@JsonProperty(value = "funding_name_id")
	@NotEmpty(message = "funding_name_id must not be null")
	private String fundingNameId;

	@JsonProperty(value = "currency")
	@NotEmpty
	private String currency;
	
	@JsonProperty(value = "amount")
	@NotNull
	private Double amount;
	
	@JsonProperty(value = "funding")
	private FundingResponseDto funding;
}
