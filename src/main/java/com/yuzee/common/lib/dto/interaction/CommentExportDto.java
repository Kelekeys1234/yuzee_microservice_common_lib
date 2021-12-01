package com.yuzee.common.lib.dto.interaction;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentExportDto {

	@NotBlank(message = "{comment_text.empty}")
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
