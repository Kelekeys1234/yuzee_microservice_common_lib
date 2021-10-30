package com.yuzee.common.lib.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.accessibility.CheckUserAccessEntityDto;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessibilityHandler {

	private final static String CHECK_ACCESSIBILITY = "check/access";

	private final static String USER_ID = "user/";

	private final static String ENTITY_ID = "entityId/";

	private final static String ENTITY_TYPE = "entityType/";
	
	private static final String MSG_ERROR_INVOKING = "Error invoking Accessibilty service";
	private static final String MSG_ERROR_NOT_FOUND = "UserAccessEntity for supplied entityId not found";

	@Autowired
	private RestTemplate restTemplate;

	public CheckUserAccessEntityDto checkAccessibility(String entityId, String grantUserId, String moduleName,
			String subModuleName, String claim, String entityType) {

		ResponseEntity<GenericWrapperDto<CheckUserAccessEntityDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.ACCESSIBILITY_CONNECTION_URL).append(CHECK_ACCESSIBILITY).append("/").append(USER_ID)
					.append(grantUserId).append("/").append(ENTITY_ID).append(entityId).append("/").append(ENTITY_TYPE)
					.append(entityType);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("moduleName", moduleName);
			uriBuilder.queryParam("subModuleName", subModuleName);
			uriBuilder.queryParam("claim", claim);

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<CheckUserAccessEntityDto>>() {
					});
		} catch (InvokeException e) {
			throw e;
		} catch (NotFound e) {
			log.error(MSG_ERROR_NOT_FOUND, e);
			throw new NotFoundException(MSG_ERROR_NOT_FOUND);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}

		return responseEntity.getBody().getData();
	}
}
