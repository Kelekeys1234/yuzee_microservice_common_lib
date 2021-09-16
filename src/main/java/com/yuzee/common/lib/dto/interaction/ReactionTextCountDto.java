package com.yuzee.common.lib.dto.interaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactionTextCountDto {

	@JsonProperty("reaction_text")
	private String reaction_text;

	@JsonProperty("count")
	private Long count;
}
