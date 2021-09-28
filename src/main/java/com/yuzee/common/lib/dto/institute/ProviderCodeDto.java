package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderCodeDto {
	@JsonProperty("id")
	private String id;

	@NotEmpty
	@JsonProperty("name")
	private String name;

	@NotEmpty
	@JsonProperty("value")
	private String value;
}
