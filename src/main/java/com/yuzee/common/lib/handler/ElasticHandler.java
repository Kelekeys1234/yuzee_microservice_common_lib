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
import com.yuzee.common.lib.dto.elastic.UsersResponseDto;
import com.yuzee.common.lib.dto.institute.FacultyDto;
import com.yuzee.common.lib.dto.institute.InstituteSyncDTO;
import com.yuzee.common.lib.enumeration.CourseTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnProperty(name = "yuzee.elastic-handler.enabled", havingValue = "true")
@Slf4j
public class ElasticHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String MSG_ERROR_INVOKING_ELASTIC = "Error invoking elastic service";
	
	private static final String MSG_ERROR_CODE = "Error response recieved from elastic service with error code ";

	private static final String GET_COURSE_BASIC_INFO_FILTER_URL = IConstant.ELASTIC_SEARCH_URL+ "api/v1/course/basic_info";
	
	private static final String GET_FACULTY_BY_FILTERS = IConstant.ELASTIC_SEARCH_URL+ "api/v1/faculty";
	
	private static final String GET_USERS_URL = IConstant.ELASTIC_SEARCH_URL+ "user";
	
	private static final String GET_INSTITUTE_FILTER_URL = IConstant.ELASTIC_SEARCH_URL+ "api/v1/institute";

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public PaginationResponseDto<List<CourseBasicInfoDto>> getFilterCoursesBasicInfo(int pageNumber ,int pageSize, String instituteId, 
			List<String> facultyName,List<String> levelName,List<String> cityNames, CourseTypeEnum campusType, List<String> courseIds, 
			String searchKeyword, List<String> excludeCourseIds){
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
			if(!CollectionUtils.isEmpty(courseIds)) {
				courseIds.stream().forEach(e -> uriBuilder.queryParam("course_ids", e));
			}
			if(!CollectionUtils.isEmpty(excludeCourseIds)) {
				excludeCourseIds.stream().forEach(e -> uriBuilder.queryParam("exclude_course_ids", e));
			}
			uriBuilder.queryParam("course_type", campusType);
			uriBuilder.queryParam("search_keyword", searchKeyword);

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
	
	public PaginationResponseDto<List<FacultyDto>> getFacultyByFilters(int pageNumber ,int pageSize, List<String> facultyIds){
		
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<FacultyDto>>>> facultyDtoResponse = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_FACULTY_BY_FILTERS)
			.append("/pageNumber/").append(pageNumber).append("/pageSize/").append(pageSize);
			
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			if(!CollectionUtils.isEmpty(facultyIds)) {
				facultyIds.stream().forEach(e -> uriBuilder.queryParam("faculty_ids", e));
			}
			facultyDtoResponse = restTemplate.exchange(uriBuilder.build(false).toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<FacultyDto>>>>() {});
			if (facultyDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + facultyDtoResponse.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + facultyDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC,e);
			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
		}
		return facultyDtoResponse.getBody().getData();
	}
	
	public UsersResponseDto getUsersByFilter(int pageNumber ,int pageSize, List<String> userIds, String name){
		ResponseEntity<GenericWrapperDto<UsersResponseDto>> usersResponseDto = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_USERS_URL)
			.append("/pageNumber/").append(pageNumber).append("/pageSize/").append(pageSize);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			if(!CollectionUtils.isEmpty(userIds)) {
				userIds.stream().forEach(e -> uriBuilder.queryParam("user_id", e));
			}
			uriBuilder.queryParam("name", name);
			usersResponseDto = restTemplate.exchange(uriBuilder.build(false).toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<UsersResponseDto>>() {});
			if (usersResponseDto.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + usersResponseDto.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + usersResponseDto.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC,e);
			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
		}
		return usersResponseDto.getBody().getData();
	}
	
	public PaginationResponseDto<List<InstituteSyncDTO>> getInstituteByFilters(int pageNumber ,int pageSize, String name,
			List<String> countryNames, Boolean isDomesticApplicationEnable,  List<String> excludeCountryName, Boolean isInternationalApplicationEnable){
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<InstituteSyncDTO>>>> response = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_INSTITUTE_FILTER_URL)
			.append("/pageNumber/").append(pageNumber).append("/pageSize/").append(pageSize);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			
			uriBuilder.queryParam("institute_name", name);
			uriBuilder.queryParam("is_domestic_application_enalbe", isDomesticApplicationEnable);
			uriBuilder.queryParam("is_international_application_enalbe", isInternationalApplicationEnable);
			
			if(!CollectionUtils.isEmpty(countryNames)) {
				countryNames.stream().forEach(c -> uriBuilder.queryParam("country_name", c));
			}
			if(!CollectionUtils.isEmpty(excludeCountryName)) {
				excludeCountryName.stream().forEach(c -> uriBuilder.queryParam("exclude_country_name", c));
			}

			response = restTemplate.exchange(uriBuilder.build(false).toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<InstituteSyncDTO>>>>() {});
			if (response.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + response.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + response.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC,e);
			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
		}
		return response.getBody().getData();
	}

}
