package com.yuzee.common.lib.dto.notification;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.Data;

@Data
public class NotificationMetaDataDto implements Serializable {

	private static final long serialVersionUID = 1164408510616362638L;
	
	
	@JsonProperty("notification_id")
	private String notificationId;
	
	@JsonProperty("target_entity_Id")
	private String targetEntityId;
	
	@JsonProperty("content_template")
	private String contentTemplate;
	
	@JsonProperty("action")
	private String action;
	
	@JsonProperty("target")
	private String target;
	
	@JsonProperty("send_in_app_notification")
	private boolean sendInAppNotification;
	
	@JsonProperty("content_template_data")
	private List<ContentTemplateDataDto> contentTemplateData;
	
	@JsonProperty("sender_profile")
	private UserInitialInfoDto senderProfile;
}
