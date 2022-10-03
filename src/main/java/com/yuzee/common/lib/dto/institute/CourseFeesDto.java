package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFeesDto {

	@JsonProperty("name")
	@NotEmpty(message = "name should not be blank")
	private String name;
	
	@JsonProperty("currency")
	@NotEmpty(message = "currency should not be blank")
	private String currency;

	@JsonProperty("amount")
	@NotNull(message = "amount should not be null")
	private Double amount;
}
