package com.yuzee.common.lib.dto.common;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CurrencyRateDto {

	@JsonProperty("currency_rate_id")
	private String id;
	
	@JsonProperty("from_currency_code")
	@NotBlank(message = "from_currency_code should not be blank")
	private String fromCurrencyCode;
	
	@JsonProperty("to_currency_code")
	@NotBlank(message = "to_currency_code should not be blank")
	private String toCurrencyCode;
	
	@JsonProperty("conversion_rate")
	@NotNull(message = "conversion_rate should not be blank")
	private Double conversionRate;
	
	@JsonProperty("from_currency_name")
	@NotBlank(message = "from_currency_name should not be blank")
	private String fromCurrencyName;
	
	@JsonProperty("to_currency_name")
	@NotBlank(message = "to_currency_name should not be blank")
	private String toCurrencyName;
	
	@JsonProperty("has_changed")
	private Boolean hasChanged;
}
