package com.yuzee.common.lib.dto.post;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class MediaFeedDto{
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("entity_type")
	private String entityType;
	
	@JsonProperty("entity_name")
	private String entityName;
	
	@JsonProperty("entity_image")
	private String entityImage;
	
	@JsonProperty("activity_id")
	private String activityId;
	
	@JsonProperty("post_id")
	private String postId;
	
	@JsonProperty("desciption")
	private String desciption;
	
	@JsonProperty("number_of_like")
	private long numberOfLikes;
	
	@JsonProperty("number_of_comment")
	private long numberOfComments;
	
	@JsonProperty("has_liked")
	private Boolean hasLiked = false;
	
	@JsonProperty("added_date")
	private String addedDate;
	
	@JsonProperty("storage")
	private List<StorageDto> storageDto = new ArrayList<>();
	
	@JsonProperty("mentioned_user_id")
	private Set<String> mentionedUserId = new HashSet<>();
	
	@JsonProperty("hash_tags")
	private Set<String> hashTags = new HashSet<>();
}
