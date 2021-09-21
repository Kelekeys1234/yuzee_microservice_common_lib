package com.yuzee.common.lib.dto.interaction;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

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
	
	@JsonProperty("users")
	private List<UserInitialInfoDto> users;
}
