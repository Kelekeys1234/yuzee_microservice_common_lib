package com.yuzee.common.lib.dto.interaction;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.VoteValueEnum;

import lombok.Data;

@Data
public class InteractionSyncDto {

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("activity_id")
	private String activityId;
	
	@JsonProperty("vote_value")
	private VoteValueEnum voteValueEnum;
	
	@JsonProperty("reaction_id")
	private String reactionId;
	
	@JsonProperty("comment_id")
	private String commentId;
	
	@JsonProperty("comment_text")
	private String commentText;
	
	// specific to GIF
	@JsonProperty("gifs")
	private Set<String> gifs = new HashSet<>();
	
	@JsonProperty("mentioned_user_id")
	private Set<String> mentionedUser = new HashSet<>();
	
	@JsonProperty("hash_tags")
	private Set<String> hashTags = new HashSet<>();
}
