package com.yuzee.common.lib.model.elastic;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderCode {
	@JsonProperty("id")
	private String id;

	@NotEmpty
	@JsonProperty("name")
	private String name;

	@NotEmpty
	@JsonProperty("value")
	private String value;
}
