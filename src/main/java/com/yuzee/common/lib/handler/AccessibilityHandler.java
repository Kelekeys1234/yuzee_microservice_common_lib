package com.yuzee.common.lib.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.accessibility.CheckUserAccessEntityDto;
import com.yuzee.common.lib.dto.accessibility.RoleEntityDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.accessibility-handler.enabled", havingValue = "true")
public class AccessibilityHandler {

	private final static String CHECK_ACCESSIBILITY = "check/access";

	private final static String GET_USER_ROLES = "admin/roles";
	
	private final static String USER_ID = "user/";

	private final static String ENTITY_ID = "entityId/";

	private final static String ENTITY_TYPE = "entityType/";

	private static final String MSG_ERROR_INVOKING = "Error invoking Accessibilty service";
	

	@Autowired
	private RestTemplate restTemplate;

	public CheckUserAccessEntityDto checkAccessibility(String entityId, String grantUserId, String moduleName,
			String subModuleName, String apiUniqueName, String entityType) {

		ResponseEntity<GenericWrapperDto<CheckUserAccessEntityDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.ACCESSIBILITY_CONNECTION_URL).append(CHECK_ACCESSIBILITY).append("/").append(USER_ID)
					.append(grantUserId).append("/").append(ENTITY_ID).append(entityId).append("/").append(ENTITY_TYPE)
					.append(entityType);
			log.info(path.toString());
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("module_name", moduleName);
			uriBuilder.queryParam("sub_module_name", subModuleName);
			uriBuilder.queryParam("apiUniqueName", apiUniqueName);
			log.info(uriBuilder.toUriString());
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<CheckUserAccessEntityDto>>() {
					});
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<RoleEntityDto> getAllUserRoles( String grantUserId) {
		ResponseEntity<GenericWrapperDto<List<RoleEntityDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.ACCESSIBILITY_CONNECTION_URL).append(GET_USER_ROLES).append("/").append(USER_ID)
					.append(grantUserId);
			log.info(path.toString());
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			log.info(uriBuilder.toUriString());
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<RoleEntityDto>>>() {
					});
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
}
