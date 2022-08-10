package com.yuzee.common.lib.dto.interaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HasUserLikeDto {

	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("has_user_like")
	private boolean hasUserLike;
	
	@JsonProperty("reaction_text")
	private String reactionText;
}
