package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EducationSystem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("education_system_id")
	private String id;

	@JsonProperty("country_name")
	@NotBlank(message = "country_name should not be blank")
	private String countryName;

	@JsonProperty("name")
	@NotBlank(message = "name should not be blank")
	private String name;

	@JsonProperty("code")
	@NotBlank(message = "code should not be blank")
	private String code;

	@JsonProperty("description")
	private String description;

	@JsonProperty("state_name")
	@NotBlank(message = "state_name should not be blank")
	private String stateName;
}
