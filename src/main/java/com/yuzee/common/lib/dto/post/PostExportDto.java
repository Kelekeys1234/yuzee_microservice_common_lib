package com.yuzee.common.lib.dto.post;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostExportDto {

		@JsonProperty("post_text")
		private String postText;
		
		@JsonProperty("user_id")
		private String userId;
		
		@JsonProperty("mentioned_user_list")
		private List<String> mentionedUserList; 
		
		@JsonProperty("post_answer_list")
		private List<String> postAnswerList;
		
		@JsonProperty("gif_list")
		private List<String> gifList;
}
