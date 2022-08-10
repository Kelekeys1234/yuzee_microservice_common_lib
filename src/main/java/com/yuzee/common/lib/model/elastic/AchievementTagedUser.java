package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.AchievementTagedUserRequestStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AchievementTagedUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7445920686052745566L;
	
	@JsonProperty("id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("user_id")
	@Field(name = "user_id")
	private String userId;
	
	@JsonProperty("request_status")
	@Field(name = "request_status")
	private String achievementTagedUserRequestStatus = AchievementTagedUserRequestStatus.PENDING.name();
}