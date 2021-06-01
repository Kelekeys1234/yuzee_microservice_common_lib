package com.yuzee.common.lib.dto.user;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SkillDto {

	@JsonProperty("user_skill_id")
	private String userSkillId;
	
	@NotBlank(message = "skill_name is required")
	@JsonProperty("skill_name")
	private String skillName;
	
	@JsonProperty("avg_review_stars")
	private Double avgReviewStars;
	
	@JsonProperty("review_counts")
	private long reviewCounts; 

	@JsonProperty("acting_user_endorsement_id")
	private String actingUserEndorsementId;
}
