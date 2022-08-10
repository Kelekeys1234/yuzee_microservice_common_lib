package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserJoinEvent implements Serializable {

	private static final long serialVersionUID = -5676775019548076851L;

	@Id
	@JsonProperty("id")
	@Field("id")
	private String id;

	@JsonProperty("user_id")
	@Field("user_id")
	private String userId;

	@JsonProperty("event_join_request_status")
	@Field("event_join_request_status")
	private String eventJoinRequestStatus;
}
