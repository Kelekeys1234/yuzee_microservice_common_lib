package com.yuzee.common.lib.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.AchievementTagedUserRequestStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievementTagedUserElasticDto {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("request_status")
	private String achievementTagedUserRequestStatus = AchievementTagedUserRequestStatus.PENDING.name();
	
}