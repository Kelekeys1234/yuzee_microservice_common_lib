package com.yuzee.common.lib.dto.elastic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.enumeration.UserConnectionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetworkSyncDto {

	@JsonProperty("follower_id")
	private String followerId;
	
	@JsonProperty("follower_entity_type")
	private EntityTypeEnum followerEntityType;
	
	@JsonProperty("following_id")
	private String followingId;
	
	@JsonProperty("following_entity_type")
	private EntityTypeEnum followingEntityType;
	
	@JsonProperty("connection_type")
	private UserConnectionType connectionType;
	
	@JsonProperty("sync_type")
	private String syncType;
	
	@JsonProperty("createdOn")
	private Date createdOn;
	
	public NetworkSyncDto(String followerId, EntityTypeEnum followerEntityType, String followingId,
			EntityTypeEnum followingEntityType, UserConnectionType connectionType, String syncType) {
		super();
		this.followerId = followerId;
		this.followerEntityType = followerEntityType;
		this.followingId = followingId;
		this.followingEntityType = followingEntityType;
		this.connectionType = connectionType;
		this.syncType = syncType;
	}
	
}
