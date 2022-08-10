package com.yuzee.common.lib.dto.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionExportDto {

	public ConnectionExportDto(String followerUserId, String followingUserId, String followingType, String followertype,
			String status, String type) {
		super();
		this.followerUserId = followerUserId;
		this.followingUserId = followingUserId;
		this.followingType = followingType;
		this.followertype = followertype;
		this.status = status;
		this.type = type;
	}

	@JsonProperty("follower_user_id")
	private String followerUserId;

	@JsonProperty("following_user_id")
	private String followingUserId;

	@JsonProperty("following_type")
	private String followingType;

	@JsonProperty("follower_type")
	private String followertype;

	@JsonProperty("status")
	private String status;

	@JsonProperty("type")
	private String type;

	@JsonProperty("follower_user_info")
	private UserInitialInfoDto followerUserInfo;
	
	@JsonProperty("following_user_info")
	private UserInitialInfoDto followingUserInfo;
}
