package com.yuzee.common.lib.dto.notification;

import java.util.List;

import lombok.Data;

@Data
public class EmailNotificationWrapperDto {
	private EmailNotificationDto notification;
	private List<String> files;
}
