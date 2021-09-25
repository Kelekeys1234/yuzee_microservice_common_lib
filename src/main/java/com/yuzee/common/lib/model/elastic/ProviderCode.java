package com.yuzee.common.lib.model.elastic;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
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
