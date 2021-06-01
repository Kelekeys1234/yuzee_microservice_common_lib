package com.yuzee.common.lib.handler;

import java.util.Arrays;
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
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.user.UserDeviceInfoDto;
import com.yuzee.common.lib.dto.user.UserDeviceInfoWrapperDto;
import com.yuzee.common.lib.dto.user.UserEducationDto;
import com.yuzee.common.lib.dto.user.UserIdList;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;
import com.yuzee.common.lib.dto.user.UserWorkExperienceDto;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.user-handler.enabled", havingValue = "true")
public class UserHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_USER_INITITAL_INFO_URL = IConstant.USER_CONNECTION_URL + "/api/v1/user/initital/info";
	private static final String GET_USER_WORK_EXPERIENCE_BY_USER_ID = IConstant.USER_CONNECTION_URL + "/api/v1/user/workexperience";
	private static final String GET_USER_EDUCATION_BY_USER_ID = IConstant.USER_CONNECTION_URL + "/api/v1/user/education";
	private static final String UPDATE_USER_WORK_EXPERIENCE = IConstant.USER_CONNECTION_URL + "/api/v1/workexperience/update/{experienceID}";
	private static final String UPDATE_USER_EDUCATION_DETAILS = IConstant.USER_CONNECTION_URL + "/api/v1/education/update/{educationID}";
	private static final String USER_ID = "userId";
	private static final String IDENTITY_INVOKE_EXCEPTION_MSG = "Error invoking user service {}";
	private static final String ERROR_FROM_USER_SERVICE_MEG = "Error response recieved from user service with error code ";
	private static final String USER_DEVICE_CONNECTION_URL = IConstant.USER_CONNECTION_URL + "/api/v1/user/device/info";
	private static final String GET_USER_DEVICE_INFO = IConstant.USER_CONNECTION_URL +"/api/v1/user/device/basic/{userId}";

	public UserEducationDto updateUserEducationByEducationId(String educationId,
			UserEducationDto userEducationRequestDto) throws InvokeException {
		ResponseEntity<UserEducationDto> userWorkExperiences = null;
		Map<String, String> params = new HashMap<>();
		params.put("educationID", educationId);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<UserEducationDto> entity = new HttpEntity<>(userEducationRequestDto, headers);
			StringBuilder path = new StringBuilder();
			path.append(UPDATE_USER_EDUCATION_DETAILS);
			userWorkExperiences = restTemplate.exchange(path.toString(), HttpMethod.PUT, entity, UserEducationDto.class,
					params);
			if (userWorkExperiences.getStatusCode().value() != 200) {
				throw new InvokeException(ERROR_FROM_USER_SERVICE_MEG + userWorkExperiences.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(IDENTITY_INVOKE_EXCEPTION_MSG,e);
		}
		return userWorkExperiences.getBody();
	}

	public List<UserEducationDto> getUserEducationByUserID(String userID) throws InvokeException {
		ResponseEntity<GenericWrapperDto<List<UserEducationDto>>> userWorkExperiences = null;

		HttpHeaders headers = new HttpHeaders();
	    headers.add(USER_ID, userID);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
	    	StringBuilder path = new StringBuilder();
			path.append(GET_USER_EDUCATION_BY_USER_ID);
			userWorkExperiences = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<UserEducationDto>>>() {});
			if (userWorkExperiences.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_USER_SERVICE_MEG + userWorkExperiences.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(IDENTITY_INVOKE_EXCEPTION_MSG,e);
		}
		return userWorkExperiences.getBody().getData();
	}

	public UserWorkExperienceDto updateUserWorkExpirienceByExperienceId(String experienceId,
			UserWorkExperienceDto userWorkExperienceDto) throws InvokeException {
		ResponseEntity<UserWorkExperienceDto> userWorkExperiences = null;
		Map<String, String> params = new HashMap<>();
		params.put("experienceID", experienceId);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<UserWorkExperienceDto> entity = new HttpEntity<>(userWorkExperienceDto, headers);
			StringBuilder path = new StringBuilder();
			path.append(UPDATE_USER_WORK_EXPERIENCE);
			userWorkExperiences = restTemplate.exchange(path.toString(), HttpMethod.PUT, entity,
					UserWorkExperienceDto.class, params);
			if (userWorkExperiences.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_USER_SERVICE_MEG + userWorkExperiences.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(IDENTITY_INVOKE_EXCEPTION_MSG,e);
		}
		return userWorkExperiences.getBody();
	}

	public List<UserWorkExperienceDto> getUserWorkExperienceByUserID(String userID) throws InvokeException {
		ResponseEntity<GenericWrapperDto<List<UserWorkExperienceDto>>> userWorkExperiences = null;

		HttpHeaders headers = new HttpHeaders();
	    headers.add(USER_ID, userID);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
	    	StringBuilder path = new StringBuilder();
			path.append(GET_USER_WORK_EXPERIENCE_BY_USER_ID);
			userWorkExperiences = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<UserWorkExperienceDto>>>() {});
			if (userWorkExperiences.getStatusCode().value() != 200) {
				throw new InvokeException(ERROR_FROM_USER_SERVICE_MEG + userWorkExperiences.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(IDENTITY_INVOKE_EXCEPTION_MSG,e);
		}
		return userWorkExperiences.getBody().getData();
	}
	
	public UserInitialInfoDto getUserById(final String userId) throws InvokeException {
		List<UserInitialInfoDto> users = getUserByIds(Arrays.asList(userId));
		UserInitialInfoDto user = null;
		if (!CollectionUtils.isEmpty(users)) {
			user = users.get(0);
		}
		return user;
	}

	public List<UserInitialInfoDto> getUserByIds(final List<String> userIds) throws InvokeException {
		ResponseEntity<GenericWrapperDto<List<UserInitialInfoDto>>> response = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_USER_INITITAL_INFO_URL);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			userIds.stream().forEach(e -> builder.queryParam("userIds", e));
			
			response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<List<UserInitialInfoDto>>>() {});
			if (response.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_USER_SERVICE_MEG + response.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw new InvokeException(IDENTITY_INVOKE_EXCEPTION_MSG,e);
		}
		return response.getBody().getData();
	}
	
	public List<UserDeviceInfoDto> getDeviceIdListBasedOnUserIds(UserIdList userIdList) throws InvokeException {
		
		ResponseEntity<GenericWrapperDto<List<UserDeviceInfoDto>>> response = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<UserIdList> entity = new HttpEntity<>(userIdList, headers);
			StringBuilder path = new StringBuilder();
			path.append(USER_DEVICE_CONNECTION_URL);
			
			response = restTemplate.exchange(path.toString(), HttpMethod.POST, entity, new ParameterizedTypeReference<GenericWrapperDto<List<UserDeviceInfoDto>>>() {});
			if (response.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_USER_SERVICE_MEG + response.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(IDENTITY_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(IDENTITY_INVOKE_EXCEPTION_MSG,e);
		}
		return response.getBody().getData();
	}
	public List<UserDeviceInfoDto> getUserDeviceInfoByUserId(String userId) throws InvokeException {
		ResponseEntity<UserDeviceInfoWrapperDto> responseEntity = null;
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("userId", userId);
			StringBuilder path = new StringBuilder();
			path.append(GET_USER_DEVICE_INFO);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null, UserDeviceInfoWrapperDto.class, params);
			if(responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException ("Error response received from identity service with error code " 
						+ responseEntity.getStatusCode().value());
			}
		} catch (Exception e) {
			log.error("Error invoking identity service {}", e);
			if (e instanceof InvokeException || e instanceof NotFoundException) {
				throw e;
			} else {
				throw new InvokeException("Error invoking identity service");
			}	
		}
		return responseEntity.getBody().getData();
	}
}
