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

	private static final String MSG_ERROR_INVOKING_ELASTIC = "Error invoking elastic service";
	
	private static final String MSG_ERROR_CODE = "Error response recieved from elastic service with error code ";

	private static final String GET_COURSE_BASIC_INFO_FILTER_URL = IConstant.ELASTIC_SEARCH_URL+ "api/v1/course/basic_info";

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	


	public PaginationResponseDto<List<CourseBasicInfoDto>> getFilterCoursesBasicInfo(int pageNumber ,int pageSize, String instituteId, 
			List<String> facultyName,List<String> levelName,List<String> cityNames, CourseTypeEnum campusType, List<String> courseIds){
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
