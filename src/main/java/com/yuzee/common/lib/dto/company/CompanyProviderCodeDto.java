package com.yuzee.common.lib.dto.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyProviderCodeDto {

	@NotBlank(message = "type can not be null / empty")
	@JsonProperty("type")
	private String type;
	
	@NotNull(message = "code can not be null / empty")
	@JsonProperty("code")
	private long code;
}
