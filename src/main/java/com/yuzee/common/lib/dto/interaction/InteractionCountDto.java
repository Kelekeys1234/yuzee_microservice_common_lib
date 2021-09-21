package com.yuzee.common.lib.dto.interaction;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteractionCountDto {
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("like_count")
	private long likeCount;
	
	@JsonProperty("comment_count")
	private long commentCount;
	
	@JsonProperty("reaction_text_counts")
	private List<ReactionTextCountDto> reactionTextCounts;
	
	public InteractionCountDto(long likeCount, long commentCount) {
		this.likeCount = likeCount;
		this.commentCount = commentCount;
	}

	public InteractionCountDto(String entityId, long likeCount, long commentCount) {
		this.entityId = entityId;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
	}

}
