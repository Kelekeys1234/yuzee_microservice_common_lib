package com.yuzee.common.lib.dto.notification;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationBean implements Serializable {

	private static final long serialVersionUID = 2451909674874404916L;
	
	@JsonProperty("notification_id")
	private String notificationId;
	
	@JsonProperty("payload")
	private PayloadDto payload;
	
	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("notification_type")
	private String notificationType;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("read_status")
	private boolean readStatus;
}
