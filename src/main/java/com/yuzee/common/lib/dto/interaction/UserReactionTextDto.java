package com.yuzee.common.lib.dto.interaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReactionTextDto {

	@JsonProperty("reaction_text")
	private String reactionText;
	
	@JsonProperty("user")
	private UserInitialInfoDto user;
}
