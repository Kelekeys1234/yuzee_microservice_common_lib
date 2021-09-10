package com.yuzee.common.lib.handler;

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

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.elastic.CourseBasicInfoDto;
import com.yuzee.common.lib.enumeration.CourseTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnProperty(name = "yuzee.elastic-handler.enabled", havingValue = "true")
@Slf4j
public class ElasticHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String SYNC_NETWORK = "api/v1/sync/network";

	private static final String MSG_ERROR_INVOKING_ELASTIC = "Error invoking elastic service";
	private static final String MSG_ERROR_CODE = "Error response recieved from elastic service with error code ";

	private static final String GET_COURSE_BASIC_INFO_FILTER_URL = IConstant.ELASTIC_SEARCH_URL+ "api/v1/course/basic_info";


	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

//	public void syncNetworkWithElastic (NetworkSyncDto networkElasticDto){
//		try {
//			StringBuilder path = new StringBuilder();
//			path.append(IConstant.ELASTIC_SEARCH_URL).append(SYNC_NETWORK);
//			ResponseEntity<String> status = restTemplate.postForEntity(path.toString(), networkElasticDto, String.class);
//			if(status.getStatusCodeValue() != 200) {
//				log.error(MSG_ERROR_CODE + status.getStatusCodeValue());
//				throw new InvokeException(MSG_ERROR_CODE + status.getStatusCodeValue());
//			}
//		} catch (InvokeException e) {
//			log.error(MSG_ERROR_INVOKING_ELASTIC, e);
//			throw e;
//		} catch (Exception e) {
//			log.error(MSG_ERROR_INVOKING_ELASTIC, e);
//			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
//		}
//	}

//	public void saveUpdateInstitutes(List<InstituteSyncDTO> institutes) {
//		List<ElasticSearchDTO> entities = institutes.stream().map(e -> {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
//			elasticSearchDto.setType(EntityTypeEnum.INSTITUTE.name());
//			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
//			elasticSearchDto.setObject(e);
//			return elasticSearchDto;
//
//		}).collect(Collectors.toList());
//		SystemEventDTO systemEvent = new  SystemEventDTO();
//		systemEvent.setEventTime(new Date().getTime());
//		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_INSTITUTE);
//		systemEvent.setPayload(new ElasticSearchBulkWrapperDto(entities));
//		saveDataOnElasticSearchInBulk(systemEvent);
//	}


//	public void saveInsituteOnElasticSearch(final String elasticSearchIndex, final String type, final List<InstituteSyncDTO> instituteList) {
//		for (InstituteSyncDTO insitute : instituteList) {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(elasticSearchIndex);
//			elasticSearchDto.setType(type);
//			elasticSearchDto.setEntityId(String.valueOf(insitute.getId()));
//			elasticSearchDto.setObject(insitute);
//			restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL, elasticSearchDto, Object.class);
//		}
//	}

//	public void updateInsituteOnElasticSearch(final String elasticSearchIndex, final String type, final List<InstituteSyncDTO> instituteList) {
//		for (InstituteSyncDTO insitute : instituteList) {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(elasticSearchIndex);
//			elasticSearchDto.setType(type);
//			elasticSearchDto.setEntityId(String.valueOf(insitute.getId()));
//			elasticSearchDto.setObject(insitute);
//			HttpHeaders headers = new HttpHeaders();
//			HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
//			restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.PUT, httpEntity, Object.class);
//		}
//	}

//	public void deleteInsituteOnElasticSearch(final String elasticSearchIndex, final String type, final List<InstituteSyncDTO> instituteList) {
//		for (InstituteSyncDTO insitute : instituteList) {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(elasticSearchIndex);
//			elasticSearchDto.setType(type);
//			elasticSearchDto.setEntityId(String.valueOf(insitute.getId()));
//			elasticSearchDto.setObject(insitute);
//			HttpHeaders headers = new HttpHeaders();
//			HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
//			restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Object.class);
//		}
//	}

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

//	public void saveUpdateData(List<CourseSyncDTO> courseList) {
//		List<ElasticSearchDTO> entities = courseList.stream().map(e -> {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
//			elasticSearchDto.setType(EntityTypeEnum.COURSE.name());
//			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
//			elasticSearchDto.setObject(e);
//			return elasticSearchDto;
//
//		}).collect(Collectors.toList());
//		SystemEventDTO systemEvent = new  SystemEventDTO();
//		systemEvent.setEventTime(new Date().getTime());
//		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_COURSE);
//		systemEvent.setPayload(new ElasticSearchBulkWrapperDto(entities));
//		
//		saveDataOnElasticSearchInBulk(systemEvent);
//	}

//	public void saveDataOnElasticSearchInBulk(SystemEventDTO systemEventDto) {
//		log.info("Handler ElasticHandler method saveDataOnElasticSearchInBulk systemEventDto : {} ", systemEventDto);
//		try {
//			String systemEvent = new ObjectMapper().writeValueAsString(systemEventDto);
//			kafkaTemplate.send(KafkaTopicEnum.SYSTEM_EVENT.name(), systemEvent);
//
//		} catch (JsonProcessingException e) {
//			log.error("Error saveDataOnElasticSearchInBulk", e);
//		}
//		//		StringBuilder path = new StringBuilder();
//		//		path.append(IConstant.ELASTIC_SEARCH_BULK);
//		//		restTemplate.postForEntity(path.toString(), elasticSearchBulkWrapperDto, Object.class);
//	}

//	public void saveArticleOnElasticSearch(final String elasticSearchIndex, final String type, final ArticleSyncDto articleDto) {
//		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//		elasticSearchDto.setIndex(elasticSearchIndex);
//		elasticSearchDto.setType(type);
//		elasticSearchDto.setEntityId(String.valueOf(articleDto.getId()));
//		elasticSearchDto.setObject(articleDto);
//		log.info("{}",elasticSearchDto);
//		restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL, elasticSearchDto, Object.class);
//	}

//	public void updateArticleOnElasticSearch(final String elasticSearchIndex, final String type, final ArticleSyncDto articleDto) {
//		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//		elasticSearchDto.setIndex(elasticSearchIndex);
//		elasticSearchDto.setType(type);
//		elasticSearchDto.setEntityId(String.valueOf(articleDto.getId()));
//		elasticSearchDto.setObject(articleDto);
//		log.info("{}",elasticSearchDto);
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
//		restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.PUT, httpEntity, Object.class);
//	}

//	public void deleteArticleOnElasticSearch(final String elasticSearchIndex, final String type, final ArticleSyncDto articleDto) {
//		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//		elasticSearchDto.setIndex(elasticSearchIndex);
//		elasticSearchDto.setType(type);
//		elasticSearchDto.setEntityId(String.valueOf(articleDto.getId()));
//		elasticSearchDto.setObject(articleDto);
//		log.info("{}",elasticSearchDto);
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
//		restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Object.class);
//	}

//	public void saveUpdateScholarship(final ScholarshipSyncDto scholarshipDto) {
//		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//		elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
//		elasticSearchDto.setType(EntityTypeEnum.SCHOLARSHIP.name());
//		elasticSearchDto.setEntityId(String.valueOf(scholarshipDto.getId()));
//		elasticSearchDto.setObject(scholarshipDto);
//		log.info("{}",elasticSearchDto);
//		restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL, elasticSearchDto, Object.class);
//	}

//	public void deleteScholarshipOnElasticSearch(final String elasticSearchIndex, final String type, final ScholarshipSyncDto scholarshipDto) {
//		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//		elasticSearchDto.setIndex(elasticSearchIndex);
//		elasticSearchDto.setType(type);
//		elasticSearchDto.setEntityId(String.valueOf(scholarshipDto.getId()));
//		elasticSearchDto.setObject(scholarshipDto);
//		log.info("{}",elasticSearchDto);
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
//		restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Object.class);
//	}

//	public void addUpdateUserDetailsOnElastic(UserSyncDto userElasticDto){
//		log.debug("Inside saveInsituteOnElasticSearch() method");
//		List<ElasticSearchDTO> elasticSearchDtoList = new ArrayList<>();
//		ElasticSearchBulkWrapperDto elasticSearchBulkWrapperDto = new ElasticSearchBulkWrapperDto();
//
//		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//		elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX_GENERIC);
//		elasticSearchDto.setType(IConstant.ELASTIC_SEARCH_USER_TYPE);
//		elasticSearchDto.setEntityId(String.valueOf(userElasticDto.getId()));
//		elasticSearchDto.setObject(userElasticDto);
//		elasticSearchDtoList.add(elasticSearchDto);
//
//		elasticSearchBulkWrapperDto.setEntities(elasticSearchDtoList);
//		SystemEventDTO systemEvent = new  SystemEventDTO();
//		systemEvent.setEventTime(new Date().getTime());
//		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_USER);
//		systemEvent.setPayload(elasticSearchBulkWrapperDto);
//		this.saveDataOnElasticSearchInBulk(systemEvent);
//	}

//	public void saveUserOnElasticSearch(String elasticSearchIndex, String type, List<UserSyncDto> userElasticDtoList) {
//		ResponseEntity<Object> object = null;
//		try {
//			log.debug("Inside saveUserOnElasticSearch() method");
//			for (UserSyncDto userElasticDto : userElasticDtoList) {
//				ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//				elasticSearchDto.setIndex(elasticSearchIndex);
//				elasticSearchDto.setType(type);
//				elasticSearchDto.setEntityId(String.valueOf(userElasticDto.getId()));
//				elasticSearchDto.setObject(userElasticDto);
//				log.info("{}",elasticSearchDto);
//				object = restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL,elasticSearchDto, Object.class);
//				if(object.getStatusCode().value() != 200) {
//					log.error(MSG_ERROR_CODE + object.getStatusCodeValue());
//					throw new InvokeException(MSG_ERROR_CODE
//							+ object.getStatusCode().value());
//				}
//			}
//		}catch (Exception e) {
//			log.error(MSG_ERROR_INVOKING_ELASTIC, e);
//		}
//	}

//	public void saveUpdateFaculties(List<FacultyDto> faculties) {
//		List<ElasticSearchDTO> entities = faculties.stream().map(e -> {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
//			elasticSearchDto.setType(EntityTypeEnum.FACULTY.name());
//			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
//			elasticSearchDto.setObject(e);
//			return elasticSearchDto;
//
//		}).collect(Collectors.toList());
//		SystemEventDTO systemEvent = new  SystemEventDTO();
//		systemEvent.setEventTime(new Date().getTime());
//		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_FACULTY);
//		systemEvent.setPayload(new ElasticSearchBulkWrapperDto(entities));
//		saveDataOnElasticSearchInBulk(systemEvent);
//	}

//	public void saveUpdateLevels(List<LevelDto> level) {
//		List<ElasticSearchDTO> entities = level.stream().map(e -> {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
//			elasticSearchDto.setType(EntityTypeEnum.LEVEL.name());
//			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
//			elasticSearchDto.setObject(e);
//			return elasticSearchDto;
//
//		}).collect(Collectors.toList());
//		SystemEventDTO systemEvent = new  SystemEventDTO();
//		systemEvent.setEventTime(new Date().getTime());
//		systemEvent.setMessageType(EventType.EVENT_TYPE_SAVE_UPDATE_LEVEL);
//		systemEvent.setPayload(new ElasticSearchBulkWrapperDto(entities));
//		saveDataOnElasticSearchInBulk(systemEvent);
//	}
//	public void saveUpdateCompanies(List<CompanySyncDto> company) {
//		List<ElasticSearchDTO> entities = company.stream().map(e -> {
//			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
//			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
//			elasticSearchDto.setType(EntityTypeEnum.COMPANY.name());
//			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
//			elasticSearchDto.setObject(e);
//			return elasticSearchDto;
//			
//		}).collect(Collectors.toList());
////		saveDataOnElasticSearchInBulk(new ElasticSearchBulkWrapperDto(entities));
//	}
	
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
