package com.yuzee.common.lib.dto.post;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.PostTypeEnum;

import lombok.Data;

@Data
public class PostSyncDto {

	@JsonProperty("post_id")
	private String postId;

	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("entity_type")
	private String entityType;

	@JsonProperty("post_type")
	private PostTypeEnum postType;
	
	@JsonProperty("post_text")
	private String postText;
	
	@JsonProperty("mentioned_user_id")
	private Set<String> MentionedUserIds = new HashSet<>();

	@JsonProperty("hash_tags")
	private Set<String> hashTags = new HashSet<>();

	
}
