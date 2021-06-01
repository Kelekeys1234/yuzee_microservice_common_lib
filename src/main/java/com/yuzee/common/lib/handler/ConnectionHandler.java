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
import com.yuzee.common.lib.dto.GenericResponse;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.connection.ConnectionExistDto;
import com.yuzee.common.lib.dto.connection.ConnectionNumberDto;
import com.yuzee.common.lib.dto.connection.FollowerCategoryDto;
import com.yuzee.common.lib.dto.connection.FollowerCountDto;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.connection-handler.enabled", havingValue = "true")
public class ConnectionHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String FOLLOW = "/follow";

	private static final String CONNECTION_EXIST = "/exist";

	private static final String FOLLOWERS_COUNT = "/count";

	private static final String GET_EXISTING_USER_BY_USER_ID = "/connection/exists/";
	private static final String GET_MUTUAL_CONNECTION_COUNT_BY_USER_ID = "/connection/multiple/count/mutual";

	private static final String GET_USER_CONNECTED_USER_ID = "/internal/connection/user/{userId}";

	private static final String CONNECTION_FOR_ENTITY_TYPE_EXISTS = "/api/v1/follow//entityType/{entityType}/exist";
	
	private static final String CONNECTION_COUNT = "/api/v1/connection/{followingId}/status/{status}/count";
	
	private static final String CONNECTION_EXISTS = "/api/v1/follow/exist/{followingId}";
	
	private static final String FOLLOW_ENTITY = "/api/v1/follow/followerType/{followerType}/followerId/{followerId}/followingType/{followingType}/followingId/{followingId}";
	
	private static final String MSG_ERROR_CODE = "Error response recieved from connection service with error code ";
	private static final String MSG_ERROR_INVOKE_CONNECTION = "Error invoking connection service";
	
	private static final String USERID = "userId";
	private static final String USER_ID = "user_id";
	private static final String FOLLOWINGID = "followingId";
	private static final String STATUS = "status";
	private static final String FOLLOWER_TYPE = "followerType";
	private static final String FOLLOWER_ID = "followerId";
	private static final String FOLLOWING_TYPE = "followingType";
	private static final String ENTITY_TYPE = "entityType";
	private static final String FOLLOWING_ID = "following_id";

	public List<String> getUserConnectionUserId(String userId) {
		log.info("Get user interested tag for user id {}",userId);
		ResponseEntity<GenericWrapperDto<List<String>>> userConnectionUserIdDtoResponse = null;
		Map<String, String> params = new HashMap<>();
		params.put(USERID, userId	);

		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_URL).append(GET_USER_CONNECTED_USER_ID);
			userConnectionUserIdDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<List<String>>>() {},params);
			if (userConnectionUserIdDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + userConnectionUserIdDtoResponse.getStatusCode().value() );
				throw new InvokeException (MSG_ERROR_CODE + userConnectionUserIdDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return userConnectionUserIdDtoResponse.getBody().getData();

	}

	public List<UserInitialInfoDto> getExistingConnnectionFilterByUserIds(String userId,List<String> userIds,int limit){
		log.info("Get user details for user id {}",userIds);
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<UserInitialInfoDto>>>> userConnectionUserIdDtoResponse = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_URL)
			.append(GET_EXISTING_USER_BY_USER_ID)
			.append("pageNumber/").append("1").append("/pageSize/").append(limit);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			userIds.stream().forEach(e -> uriBuilder.queryParam(FOLLOWING_ID, e));
			uriBuilder.queryParam(STATUS, "ACTIVE");

			HttpHeaders headers = new HttpHeaders();
			headers.add(USERID,userId);
			HttpEntity<String> body = new HttpEntity<>(headers);

			userConnectionUserIdDtoResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, body, new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<UserInitialInfoDto>>>>() {});
			if (userConnectionUserIdDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + userConnectionUserIdDtoResponse.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + userConnectionUserIdDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return userConnectionUserIdDtoResponse.getBody().getData().getResponse();
	}

	public List<UserInitialInfoDto> getMutualConnectionCountByIdList(String userId,List<String> userIds){
		log.info("Get user details for user id {}",userIds);
		ResponseEntity<GenericWrapperDto<List<UserInitialInfoDto>>> userConnectionUserIdDtoResponse = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_URL)
			.append(GET_MUTUAL_CONNECTION_COUNT_BY_USER_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			userIds.stream().forEach(e -> uriBuilder.queryParam(USER_ID, e));

			HttpHeaders headers = new HttpHeaders();
			headers.add(USERID,userId);

			HttpEntity<String> body = new HttpEntity<>(headers);

			userConnectionUserIdDtoResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, body, new ParameterizedTypeReference<GenericWrapperDto<List<UserInitialInfoDto>>>() {});
			if (userConnectionUserIdDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + userConnectionUserIdDtoResponse.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + userConnectionUserIdDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return userConnectionUserIdDtoResponse.getBody().getData();
	}

	public Integer getTotalMutualConnectionCount(String userId, String visitedUserId) {
		ResponseEntity<GenericWrapperDto<ConnectionNumberDto>> result;
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(IConstant.CONNECTION_URL + "/follow/mutual/count");
		builder.queryParam(USERID, userId);
		builder.queryParam("visitedUserId", visitedUserId);

		try {
			result = restTemplate.exchange(builder.build().toUri(),HttpMethod.GET ,null, new ParameterizedTypeReference<GenericWrapperDto<ConnectionNumberDto>>() {});
			if(result.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + result.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + result.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return (int)result.getBody().getData().getConnectionNumber();
	}

	public Boolean userConnectionExist(String userId, String visitedUserId) {
		ResponseEntity<GenericWrapperDto<ConnectionExistDto>> result;
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(IConstant.CONNECTION_URL + "/follow/exist/" + visitedUserId);

		HttpHeaders headers = new HttpHeaders();
		headers.set(USERID, userId);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		try {
			result = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, entity, 
					new ParameterizedTypeReference<GenericWrapperDto<ConnectionExistDto>>() {});
			if(result.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + result.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + result.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return result.getBody().getData().isConnectionExist();
	}

	public FollowerCountDto getFollowersCount(String entityId) {
		ResponseEntity<GenericWrapperDto<FollowerCountDto>> getFollowersCountResponse = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_URL).append(FOLLOW).append(FOLLOWERS_COUNT);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.pathSegment(entityId);

			getFollowersCountResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<FollowerCountDto>>() {
			});
			if (getFollowersCountResponse.getStatusCode().value() != 200) {
				log.error("Error response recieved from connection service with error code:",
						getFollowersCountResponse.getStatusCode().value());
				throw new InvokeException("Error response recieved from connection service with error code:"
						+ getFollowersCountResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return getFollowersCountResponse.getBody().getData();
	}

	public boolean checkFollowerExist(String userId, String instituteId) {
		ResponseEntity<GenericWrapperDto<ConnectionExistDto>> getFollowersCountResponse = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_URL).append(FOLLOW).append(CONNECTION_EXIST);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.pathSegment(instituteId);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set(USERID, userId);
			HttpEntity<?> entity = new HttpEntity<>(responseHeaders);

			getFollowersCountResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<ConnectionExistDto>>() {
			});
			if (getFollowersCountResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE,
						getFollowersCountResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ getFollowersCountResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return getFollowersCountResponse.getBody().getData().isConnectionExist();
	}

	public boolean checkConnectionExistForSpecificType(String followerGuid, EntityTypeEnum entityType) {
		ResponseEntity<GenericWrapperDto<ConnectionExistDto>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		params.put(ENTITY_TYPE, entityType.name());

		HttpHeaders headers = new HttpHeaders();
		headers.add(USERID,followerGuid);
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_BASE_PATH).append(CONNECTION_FOR_ENTITY_TYPE_EXISTS);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<GenericWrapperDto<ConnectionExistDto>>() {}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return responseEntity.getBody().getData().isConnectionExist();
	}
	
	public FollowerCountDto getConnectionCount(String entityId,String status)  {
		ResponseEntity<GenericWrapperDto<FollowerCountDto>> getFollowersCountResponse = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put(FOLLOWINGID, entityId);
			params.put(STATUS,status);
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_BASE_PATH).append(CONNECTION_COUNT);

			getFollowersCountResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<FollowerCountDto>>() {},params);
			if (getFollowersCountResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ getFollowersCountResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ getFollowersCountResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return getFollowersCountResponse.getBody().getData();
	}
	public boolean checkFollowerExists(String followerGuid, String followingGuid ) {
		ResponseEntity<GenericWrapperDto<ConnectionExistDto>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
	    params.put(FOLLOWINGID, followingGuid);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(USERID,followerGuid);
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_BASE_PATH).append(CONNECTION_EXISTS);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<GenericWrapperDto<ConnectionExistDto>>() {}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return responseEntity.getBody().getData().isConnectionExist();
	}
	

	public GenericResponse updateUserFollowerCategory(String followerType, String followerId, String followingType,
			String followingId, FollowerCategoryDto followCategoryDto) {
		ResponseEntity<GenericResponse> responseEntity = null;
		Map<String, String> params = new HashMap<>();
	    params.put(FOLLOWER_TYPE, followerType);
	    params.put(FOLLOWER_ID, followerId);
	    params.put(FOLLOWING_TYPE, followingType);
	    params.put(FOLLOWINGID, followingId);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(USERID,followerId);
	    headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.CONNECTION_BASE_PATH).append(FOLLOW_ENTITY);
			
			HttpEntity<FollowerCategoryDto> body = new HttpEntity<>(followCategoryDto,headers);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, body, GenericResponse.class, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_CONNECTION,e);
			throw new InvokeException(MSG_ERROR_INVOKE_CONNECTION);
		}
		return responseEntity.getBody();
	}
}
