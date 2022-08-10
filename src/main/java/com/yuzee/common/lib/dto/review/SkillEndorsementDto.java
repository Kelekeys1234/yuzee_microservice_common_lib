package com.yuzee.common.lib.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class SkillEndorsementDto {
	
	@JsonProperty("skill_endorsement_id")
	private String skillEndorsemenId;
	
	@JsonProperty(value = "source_entity_id",access = Access.READ_ONLY)
	private String sourceEntityId;
	
	@JsonProperty(value = "source_entity_type",access = Access.READ_ONLY)
	private String sourceEntityType;
	
	@JsonProperty("target_entity_id")
	private String targetEntityId;

	@JsonProperty("target_entity_type")
	private String targetEntityType;

	@JsonProperty("skill_name")
	private String skillName;
	
	@JsonProperty("review_stars")
	private double reviewStars;
	
	@JsonProperty("how_do_you_know")
	private String howDoYouKnow;
}
