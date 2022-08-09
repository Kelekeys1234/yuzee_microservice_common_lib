package com.yuzee.common.lib.dto.authorization;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeDto {
	
	@NotBlank(message = "name should not be blank or empty")
	@JsonProperty("name")
	private String name;
	
	@NotBlank(message = "displayName should not be blank or empty")
	@JsonProperty("display_name")
	private String displayName;
}
