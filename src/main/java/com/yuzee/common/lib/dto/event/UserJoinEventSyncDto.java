package com.yuzee.common.lib.dto.event;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserJoinEventSyncDto implements Serializable {

	private static final long serialVersionUID = -5676775019548076851L;

	@JsonProperty("id")
	private String id;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("event_join_request_status")
	private String eventJoinRequestStatus;
}
