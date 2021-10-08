package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.application.EnableApplicationDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.application-handler.enabled", havingValue = "true")
public class ApplicationHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String ERROR_FROM_APPLICATION_SERVICE_MEG = "Error response recieved from application service with error code ";

	private static final String APPLICATION_INVOKE_EXCEPTION_MSG = "Error invoking application service {}";

	private static final String URL_SEPARATOR = "/";

	private static final String UPDATE_USER_APPLICATION_STATUS = IConstant.APPLICATION_CONNECTION_URL
			+ "/user/application";

	private static final String GET_ENABLE_APPLICATIONS_BY_ET_EI = IConstant.APPLICATION_CONNECTION_URL
			+ "/enable/application/entity/{entityType}";

	private static final String STATUS = "/status";

	public void updateUserApplicationStatus(String userId, String id, String userApplicationStatus)
			throws InvokeException {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;

		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId);
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			StringBuilder path = new StringBuilder();
			path.append(UPDATE_USER_APPLICATION_STATUS).append(URL_SEPARATOR).append(id).append(STATUS);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("user_application_status", userApplicationStatus);
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {
					});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(ERROR_FROM_APPLICATION_SERVICE_MEG + responseEntity.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(APPLICATION_INVOKE_EXCEPTION_MSG, e);
			throw e;
		} catch (Exception e) {
			throw new InvokeException(APPLICATION_INVOKE_EXCEPTION_MSG, e);
		}
	}

	public Map<String, List<EnableApplicationDto>> getEnableApplications(String entityType, List<String> entityIds) {
		ResponseEntity<GenericWrapperDto<List<EnableApplicationDto>>> responseEntity = null;
		Map<String, List<EnableApplicationDto>> map = new HashMap<>();
		if (CollectionUtils.isEmpty(entityIds)) {
			return map;
		}
		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_ENABLE_APPLICATIONS_BY_ET_EI);
			Map<String, String> urlParams = new HashMap<>();
			urlParams.put("entityType", entityType);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			entityIds.stream().forEach(e -> uriBuilder.queryParam("entityIds", e));

			responseEntity = restTemplate.exchange(uriBuilder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<EnableApplicationDto>>>() {
					});

			if (responseEntity.getStatusCode().value() != 200) {
				log.error(ERROR_FROM_APPLICATION_SERVICE_MEG + responseEntity.getStatusCode().value());
				throw new InvokeException(ERROR_FROM_APPLICATION_SERVICE_MEG + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(APPLICATION_INVOKE_EXCEPTION_MSG, e);
			throw e;
		} catch (Exception e) {
			log.error(APPLICATION_INVOKE_EXCEPTION_MSG, e);
			throw new InvokeException(APPLICATION_INVOKE_EXCEPTION_MSG);
		}

		List<EnableApplicationDto> dtos = responseEntity.getBody().getData();
		if (!CollectionUtils.isEmpty(dtos)) {
			map = dtos.stream().collect(Collectors.groupingBy(EnableApplicationDto::getEntityId));
		}
		return map;
	}
}
