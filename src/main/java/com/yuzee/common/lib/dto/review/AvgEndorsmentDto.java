package com.yuzee.common.lib.dto.review;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvgEndorsmentDto {

	@JsonProperty("skill_name")
	private String skillName;
	
	@JsonProperty("avg_review_stars")
	private double avgReviewStars;
	
	@JsonProperty("review_counts")
	private long reviewCount;
}
