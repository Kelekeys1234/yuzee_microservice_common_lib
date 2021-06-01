package com.yuzee.common.lib.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Skill {

	@JsonProperty("id")
	private String id;

	@JsonProperty("skill_name")
	private String skillName;

}
