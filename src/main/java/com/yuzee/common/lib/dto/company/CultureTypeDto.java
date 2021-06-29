package com.yuzee.common.lib.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CultureTypeDto{

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("also_known_as")
	private String alsoKnownAs;

	@JsonProperty("qualities")
	private String qualities;

	@JsonProperty("main_values")
	private String mainValues;

	@JsonProperty("leadership_characteristics")
	private String leadershipCharacteristics;

	@JsonProperty("motto")
	private String motto;

	@JsonProperty("about")
	private String about;

	@JsonProperty("benefits")
	private String benefits;

	@JsonProperty("drawbacks")
	private String drawbacks;

	@JsonProperty("commonly_found_in")
	private String commonFoundIn;

	@JsonProperty("examples")
	private String examples;
	
	@JsonProperty("is_admin")
	private Boolean isAdmin;

}