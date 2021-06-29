package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.institute.CourseDto;
import com.yuzee.common.lib.dto.institute.InstituteBasicInfoDto;
import com.yuzee.common.lib.dto.institute.InstituteDto;
import com.yuzee.common.lib.dto.institute.InstituteWrapperDto;
import com.yuzee.common.lib.dto.institute.ScholarshipDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.institute.enabled", havingValue = "true")
public class InstituteHandler {


	private static final String GET_COURSE_BY_ID = "course/courseIds";
	private static final String GET_INSTITUTE_BY_ID = "/public/basic/info";
	private static final String GET_SCHOLARSHIP_BY_ID = "/scholarship/multiple/id";
	private static final String GET_INSTITUTE_BY_MULTIPLE_ID = "/institute/multiple/id";
	private static final String GET_IS_CAREER_TEST_COMPLETED= "/career-test-result/is-completed";
	private static final String USER_ID = "userId";
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String MSG_ERROR_CODE = "Error response recieved from Institute service with error code ";
	private static final String MSG_ERROR_INVOKING = "Error invoking Institute service";
	public InstituteBasicInfoDto getInstituteById(String instituteId) {
		return getInstituteById(instituteId, false);
	}
	public InstituteBasicInfoDto getInstituteById(String instituteId, boolean includeDetail){
		ResponseEntity<GenericWrapperDto<InstituteBasicInfoDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_INSTITUTE_BY_ID).append("/").append(instituteId);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("includeDetail", includeDetail);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			HttpEntity<String> request = new HttpEntity<>(headers);

			log.info("Request URI: {}",uriBuilder.toUriString());
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, request,
					new ParameterizedTypeReference<GenericWrapperDto<InstituteBasicInfoDto>>() {});

			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	public List<CourseDto> getCourseByIds(List<String> courseIds) {
		ResponseEntity<InstituteWrapperDto> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_COURSE_BY_ID);
			HttpEntity<List<String>> body = new HttpEntity<>(courseIds);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, body, InstituteWrapperDto.class);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<ScholarshipDto> getScholarships(List<String> instituteIds) {
		ResponseEntity<GenericWrapperDto<List<ScholarshipDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_SCHOLARSHIP_BY_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			instituteIds.stream().forEach(e -> uriBuilder.queryParam("scholarship_ids", e));

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<ScholarshipDto>>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<InstituteDto> getInstitutes(List<String> instituteIds) {
		ResponseEntity<GenericWrapperDto<List<InstituteDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_INSTITUTE_BY_MULTIPLE_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			instituteIds.stream().forEach(e -> uriBuilder.queryParam("institute_ids", e));

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<InstituteDto>>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public boolean checkIfCareerTestCompleted(String userId) {
		ResponseEntity<GenericWrapperDto<Boolean>> response = null;
		try {
			Map<String, String> params = new HashMap<>();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(USER_ID, userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_IS_CAREER_TEST_COMPLETED);

			response = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<Boolean>>() {},params);
			if (response.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_INVOKING,
						response.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_INVOKING
						+ response.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return response.getBody().getData();
	}
}
