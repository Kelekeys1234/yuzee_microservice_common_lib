package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.eligibility.FundingResponseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDeliveryModeFundingDto {

	@JsonProperty("id")
	private String id;

	@JsonProperty(value = "funding_name_id")
	@NotEmpty(message = "funding_name_id must not be null")
	@Field("funding_name_id")
	private String fundingNameId;

	@JsonProperty(value = "name")
	@NotEmpty
	private String name;
	
	@JsonProperty(value = "currency")
	@NotEmpty
	private String currency;
	
	@JsonProperty(value = "amount")
	@NotNull
	private Double amount;
	
	@JsonProperty(value = "funding")
	private FundingResponseDto funding;

	public CourseDeliveryModeFundingDto(String id, String fundingNameId, String name, String currency, Double amount) {
		super();
		this.id = id;
		this.fundingNameId = fundingNameId;
		this.name = name;
		this.currency = currency;
		this.amount = amount;
	}
}
