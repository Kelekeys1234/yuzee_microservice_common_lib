package com.yuzee.common.lib.dto.connection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.ElasticSyncType;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.enumeration.UserConnectionType;

import lombok.Data;

@Data
public class NetworkElasticDto {

	@JsonProperty("follower_id")
	@NotEmpty(message = "follower_id should not be null/empty")
	private String followerId;
	
	@JsonProperty("follower_entity_type")
	@NotNull(message = "follower_entity_type should not be null/empty")
	private EntityTypeEnum followerEntityType;
	
	@JsonProperty("following_id")
	@NotEmpty(message = "following_id should not be null/empty")
	private String followingId;
	
	@JsonProperty("following_entity_type")
	@NotNull(message = "following_entity_type should not be null/empty")
	private EntityTypeEnum followingEntityType;
	
	@JsonProperty("connection_type")
	@NotNull(message = "connection_type should not be null/empty")
	private UserConnectionType connectionType;
	
	@JsonProperty("sync_type")
	@NotNull(message = "sync_type should not be null/empty")
	private ElasticSyncType syncType;
	
}
