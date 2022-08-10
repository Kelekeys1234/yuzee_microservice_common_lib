
package com.yuzee.common.lib.dto.notification;

import java.io.Serializable;

import lombok.Data;

@Data
public class NotificationMessageDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7414584428029939575L;
	
	private String title;
	private String content;
}
