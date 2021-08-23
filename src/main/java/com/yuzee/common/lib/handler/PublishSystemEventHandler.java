package com.yuzee.common.lib.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
import com.yuzee.common.lib.dto.elastic.CourseBasicInfoDto;
import com.yuzee.common.lib.dto.elastic.ElasticSearchDTO;
import com.yuzee.common.lib.dto.elastic.NetworkSyncDto;
import com.yuzee.common.lib.dto.elastic.UserSyncDto;
import com.yuzee.common.lib.dto.institute.ArticleSyncDto;
import com.yuzee.common.lib.dto.institute.CourseSyncDTO;
import com.yuzee.common.lib.dto.institute.FacultySyncDto;
import com.yuzee.common.lib.dto.institute.InstituteSyncDTO;
import com.yuzee.common.lib.dto.institute.LevelSyncDto;
import com.yuzee.common.lib.dto.institute.ScholarshipElasticDto;
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

	public void syncScholarships(List<ScholarshipElasticDto> scholarships) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_SCHOLARSHIP);
		systemEvent.setPayload(scholarships);
		syncData(systemEvent);
	}

	public void syncUsers(List<UserSyncDto> users) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_USER);
		systemEvent.setPayload(users);
		syncData(systemEvent);
	}

	public void syncFaculties(List<FacultySyncDto> faculites) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_FACULTY);
		systemEvent.setPayload(faculites);
		syncData(systemEvent);
	}

	public void syncLevels(List<LevelSyncDto> levels) {
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_LEVEL);
		systemEvent.setPayload(levels);
		syncData(systemEvent);
	}

	public void syncNetwork (List<NetworkSyncDto> networks){
		SystemEventDTO systemEvent = new  SystemEventDTO();
		systemEvent.setEventTime(new Date().getTime());
		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_NETWORK);
		systemEvent.setPayload(networks);
		syncData(systemEvent);
	}
	
//	public void deleteCourseOnElasticSearch(final String elasticSearchIndex, final String type, final List<CourseSyncDTO> courseList) {
//		for (CourseSyncDTO courseElasticSearch : courseList) {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(elasticSearchIndex);
//			elasticSearchDto.setType(type);
//			elasticSearchDto.setEntityId(String.valueOf(courseElasticSearch.getId()));
//			elasticSearchDto.setObject(courseElasticSearch);
//			HttpHeaders headers = new HttpHeaders();
//			HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
//			restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Map.class);
//		}
//	}
	
	public void syncData(SystemEventDTO systemEventDto) {
		log.info("Handler ElasticHandler method saveDataOnElasticSearchInBulk systemEventDto : {} ", systemEventDto);
		String systemEvent;
		try {
			systemEvent = new ObjectMapper().writeValueAsString(systemEventDto);
			kafkaTemplate.send(KafkaTopicEnum.SYSTEM_EVENT.name(), systemEvent);

		} catch (JsonProcessingException e) {
			log.error("Error saveDataOnElasticSearchInBulk", e);
		}
	}


	public PaginationResponseDto<List<CourseBasicInfoDto>> getFilterCoursesBasicInfo(int pageNumber ,int pageSize, String instituteId, List<String> facultyName,List<String> levelName,List<String> cityNames, CourseTypeEnum campusType){
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<CourseBasicInfoDto>>>> courseDtoResponse = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_COURSE_BASIC_INFO_FILTER_URL)
			.append("/pageNumber/").append(pageNumber).append("/pageSize/").append(pageSize);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("institute_id", instituteId);
			if(!CollectionUtils.isEmpty(levelName)) {
				levelName.stream().forEach(e -> uriBuilder.queryParam("level_name", e));
			}
			if(!CollectionUtils.isEmpty(facultyName)) {
				facultyName.stream().forEach(e -> uriBuilder.queryParam("faculty_names", e));
			}
			if(!CollectionUtils.isEmpty(cityNames)) {
				cityNames.stream().forEach(e -> uriBuilder.queryParam("city_names", e));
			}
			uriBuilder.queryParam("course_type", campusType);

			courseDtoResponse = restTemplate.exchange(uriBuilder.build(false).toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<CourseBasicInfoDto>>>>() {});
			if (courseDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + courseDtoResponse.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + courseDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC,e);
			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
		}
		return courseDtoResponse.getBody().getData();
	}

}
