package com.yuzee.common.lib.dto.notification;

import java.io.Serializable;

import lombok.Data;

@Data
public class PayloadDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6679075969659896232L;
	private String platform;
	private NotificationMessageDto message;
	private NotificationMetaDataDto metaData;
}
