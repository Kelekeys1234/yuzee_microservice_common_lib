package com.yuzee.common.lib.handler;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.SystemEventDTO;
import com.yuzee.common.lib.dto.notification.EmailNotificationDto;
import com.yuzee.common.lib.dto.notification.EmailNotificationWrapperDto;
import com.yuzee.common.lib.dto.notification.EmailPayloadDto;
import com.yuzee.common.lib.dto.notification.NotificationTemplateDataDto;
import com.yuzee.common.lib.enumeration.EventType;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.util.ObjectMapperHelper;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.notification-handler.enabled", havingValue = "true")
public class NotificationHandler{
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(final String textMessage) {
		log.info("Sending message " + textMessage);
		kafkaTemplate.send(IConstant.EVENT_QUEUE_NOTIFICATION, textMessage);
	}
	
	public void sendPushNotification(NotificationTemplateDataDto notificationDto){
		try {
			sendMessage(ObjectMapperHelper.toCompactJSON(createSystemEventDTO(EventType.EVENT_TYPE_NOTIFICATION,notificationDto)));
		} catch (Exception e) {
			log.error("Error invoking notification service {}", e);
			throw new InvokeException("Error invoking notification service");
		}
	}
	
	public int sendEmailNotificationWithAttachment(String emailAddress,String subject, String user, List<File> listOfFiles) {
		int status = 200;
		EmailNotificationDto emailNotificationDto = new EmailNotificationDto();
		EmailPayloadDto emailPayloadDto = new EmailPayloadDto();
        emailPayloadDto.setToaddress(emailAddress);
		emailPayloadDto.setSubject(subject);

		emailNotificationDto.setChannel("EMAIL");
		emailNotificationDto.setUser(user);
		emailNotificationDto.setUserId("uploader");
		emailNotificationDto.setNotificationType("Email");

		emailPayloadDto.setBody("Please find below Attachment");
		emailNotificationDto.setPayload(emailPayloadDto);
		
		EmailNotificationWrapperDto notificationWrapper = new EmailNotificationWrapperDto();
		notificationWrapper.setNotification(emailNotificationDto);		
		notificationWrapper.setFiles(listOfFiles.stream().map(File::getName).collect(Collectors.toList()));
		sendMessage(ObjectMapperHelper.toCompactJSON(createSystemEventDTO(EventType.EVENT_TYPE_EMAIL_NOTIFICATION,notificationWrapper)));
		return status;
	}
	
	public void emailUpdateRequest(EmailNotificationDto emailNotificationDto) {
		try {
			EmailNotificationWrapperDto notificationWrapper = new EmailNotificationWrapperDto();
			notificationWrapper.setNotification(emailNotificationDto);			
			sendMessage(ObjectMapperHelper.toCompactJSON(createSystemEventDTO(EventType.EVENT_TYPE_EMAIL_NOTIFICATION,notificationWrapper)));
		} catch (Exception e) {
			log.error("Error invoking notification service {}", e);
			throw new InvokeException("Error invoking notification service");
		}
	}
	
	private SystemEventDTO createSystemEventDTO(EventType eventType,Object obj) {
		return new SystemEventDTO(new Date().getTime(),eventType, obj);
	}
}
