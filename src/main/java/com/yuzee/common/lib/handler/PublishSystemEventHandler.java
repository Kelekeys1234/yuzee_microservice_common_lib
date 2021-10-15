package com.yuzee.common.lib.handler;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.SystemEventDTO;
import com.yuzee.common.lib.dto.company.CompanySyncDto;
import com.yuzee.common.lib.dto.elastic.CourseBasicInfoDto;
import com.yuzee.common.lib.dto.elastic.NetworkSyncDto;
import com.yuzee.common.lib.dto.elastic.UserSyncDto;
import com.yuzee.common.lib.dto.event.EventSyncDto;
import com.yuzee.common.lib.dto.institute.CourseSyncDTO;
import com.yuzee.common.lib.dto.institute.FacultyDto;
import com.yuzee.common.lib.dto.institute.InstituteSyncDTO;
import com.yuzee.common.lib.dto.institute.LevelDto;
import com.yuzee.common.lib.dto.scholarship.ScholarshipSyncDto;
import com.yuzee.common.lib.dto.interaction.InteractionSyncDto;
import com.yuzee.common.lib.dto.job.JobSyncDto;
import com.yuzee.common.lib.dto.post.PostSyncDto;
import com.yuzee.common.lib.enumeration.CourseTypeEnum;
import com.yuzee.common.lib.enumeration.EventType;
import com.yuzee.common.lib.enumeration.KafkaTopicEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnProperty(name = "yuzee.publish-system-event-handler.enabled", havingValue = "true")
@Slf4j
public class PublishSystemEventHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String MSG_ERROR_INVOKING_ELASTIC = "Error invoking elastic service";
	private static final String MSG_ERROR_CODE = "Error response recieved from elastic service with error code ";

	private static final String GET_COURSE_BASIC_INFO_FILTER_URL = IConstant.ELASTIC_SEARCH_URL+ "api/v1/course/basic_info";


	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void syncInstitutes(List<InstituteSyncDTO> institutes) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_INSTITUTE);
		systemEvent.setPayload(institutes);
		syncData(systemEvent);
	}
	
	public void syncCourses(List<CourseSyncDTO> courses) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_COURSE);
		systemEvent.setPayload(courses);
		syncData(systemEvent);
	}

	public void syncScholarships(List<ScholarshipSyncDto> scholarships) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_SCHOLARSHIP);
		systemEvent.setPayload(scholarships);
		syncData(systemEvent);
	}

	public void syncUsers(List<UserSyncDto> users, EventType eventType) { // sync data of elastic and getstream
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(users);
		syncData(systemEvent);
	}

	public void syncFaculties(List<FacultyDto> faculites) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_FACULTY);
		systemEvent.setPayload(faculites);
		syncData(systemEvent);
	}

	public void syncLevels(List<LevelDto> levels) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_LEVEL);
		systemEvent.setPayload(levels);
		syncData(systemEvent);
	}

	public void syncNetwork (List<NetworkSyncDto> networks, EventType eventType){ // sync data of elastic and getstream
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(networks);
		syncData(systemEvent);
	}
	
	public void syncCompanies(List<CompanySyncDto> companies) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_COMPANY);
		systemEvent.setPayload(companies);
		syncData(systemEvent);
	}
	
	public void syncData(SystemEventDTO systemEventDto) { // sync data of elastic and getstream
		log.info("Handler PublishSystemEventHandler method syncData systemEventDto : {} ", systemEventDto);
	
		try {
			String systemEvent = new ObjectMapper().writeValueAsString(systemEventDto);
			kafkaTemplate.send(KafkaTopicEnum.SYSTEM_EVENT.name(), systemEvent);

		} catch (JsonProcessingException e) {
			log.error("Error syncData", e);
		}
	}

//	----------------- get-stream ----------------------
	
	public void syncUserProfilePicture(List<UserSyncDto> syncUsers, EventType eventType) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(syncUsers);
		syncData(systemEvent);
	}
	
	public void syncPost(List<PostSyncDto> syncPosts, EventType eventType) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(syncPosts);
		syncData(systemEvent);
	}

	public void syncEvent(List<EventSyncDto> syncEvents, EventType eventType) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(syncEvents);
		syncData(systemEvent);
	}
	
	public void syncVotes(List<InteractionSyncDto> syncVotes, EventType eventType) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(syncVotes);
		syncData(systemEvent);
	}

	public void syncReaction(List<InteractionSyncDto> syncReaction, EventType eventType) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(syncReaction);
		syncData(systemEvent);
	}

	public void syncComments(List<InteractionSyncDto> syncComments, EventType eventType) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(eventType);
		systemEvent.setPayload(syncComments);
		syncData(systemEvent);
	}
	
	public void syncJobs(List<JobSyncDto> jobs) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_JOB);
		systemEvent.setPayload(jobs);
		syncData(systemEvent);
	}
}
