package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.application.EnrollmentCountDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.enrollment-handler.enabled", havingValue = "true")
public class EnrollmentHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_ENROLLMENT_COUNT = "/enrollment/count/courseId/{courseId}";

	private static final String MSG_ERROR_CODE = "Error response recieved from Application service with error code ";
	private static final String MSG_ERROR_INVOKE = "Error invoking Application service";
	
	public Integer getTotalCountOfEnrollment(String userId, String courseId){
		ResponseEntity<GenericWrapperDto<EnrollmentCountDto>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		try {
			params.put("courseId", courseId);
			HttpHeaders headers = new HttpHeaders();
			headers.add("userId", userId);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			StringBuilder path = new StringBuilder();
			path.append(IConstant.APPILICATION_URL).append(GET_ENROLLMENT_COUNT);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<EnrollmentCountDto>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKE, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKE, e);
			throw new InvokeException(MSG_ERROR_INVOKE);
		}
		return responseEntity.getBody().getData().getEnrollmentCount();
	}
}
