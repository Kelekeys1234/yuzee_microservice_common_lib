package com.yuzee.common.lib.dto.interaction;

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
	
	public InteractionCountDto(long likeCount, long commentCount) {
		this.likeCount = likeCount;
		this.commentCount = commentCount;
	}

}
