package com.yuzee.common.lib.dto.interaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VoteCommentCountDto {

	@JsonProperty("upvote_count")
	private long upvoteCount = 0;
	
	@JsonProperty("downvote_count")
	private long downvoteCount = 0;
	
	@JsonProperty("comment_count")
	private long commentCount = 0;
	
}
