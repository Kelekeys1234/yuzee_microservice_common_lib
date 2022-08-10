package com.yuzee.common.lib.dto.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserSkillDto {

	@NotBlank(message = "privacy_level is required")
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@Valid
	@JsonProperty("skills")
	private List<SkillDto> skills = new ArrayList<>();
}
