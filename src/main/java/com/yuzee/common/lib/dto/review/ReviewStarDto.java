package com.yuzee.common.lib.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewStarDto {

	@JsonProperty("entity_id")
	private String entityId;

	@JsonProperty("review_stars")
	private Double reviewStars;
	
	@JsonProperty("reviews_count")
	private Long reviewsCount;
}
