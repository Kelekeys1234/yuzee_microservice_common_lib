package com.yuzee.common.lib.dto.interaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {

	@JsonProperty("tag_id")
	private String tagId;
	
	@JsonProperty("tag_text")
	private String tagText;
	
	@JsonProperty("post_count")
	private long postCount;
}
