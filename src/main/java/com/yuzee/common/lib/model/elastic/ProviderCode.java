package com.yuzee.common.lib.model.elastic;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProviderCode {


	@NotEmpty
	@JsonProperty("name")
	private String name;

	@NotEmpty
	@JsonProperty("value")
	private String value;

	public ProviderCode(@NotEmpty String name, @NotEmpty String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
}
