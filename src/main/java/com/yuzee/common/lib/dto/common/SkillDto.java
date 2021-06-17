package com.yuzee.common.lib.dto.common;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SkillDto {

	@JsonProperty("skill_id")
	private String id;

	@NotBlank(message = "skill_name should not be empty / blank")
	@JsonProperty("skill_name")
	private String skillName;

	@JsonProperty("icon")
	private String icon;
}
