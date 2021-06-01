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
import com.yuzee.common.lib.dto.transaction.TransactionCountDto;
import com.yuzee.common.lib.dto.transaction.TransactionExistsDto;
import com.yuzee.common.lib.dto.transaction.UserMyCourseDto;
import com.yuzee.common.lib.dto.transaction.UserViewCourseDto;
import com.yuzee.common.lib.dto.transaction.ViewTransactionDto;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.enumeration.TransactionTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.view-transaction-handler.enabled", havingValue = "true")
public class ViewTransactionHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_USER_MY_COURSE = "/user/entityType/{entityType}/transactionType/{transactionType}";

	private static final String GET_USER_VIEW_COURSE = "/user/view?entityType={entityType}&entityId={entityId}"
			+ "&transactionType={transactionType}";

	private static final String GET_USERS_MARK_COURSE_FAVORITE = "/entityType/{entityType}/entityId/{entityId}/transactionType/{transactionType}";

	private static final String ENTITY_TYPE = "entityType";

	private static final String TRANSACTION_TYPE = "transactionType";

	private static final String ENTTIY_ID = "entityId";

	private static final String USER_ID = "userId";

	private static final String GET_USER_VIEW_COURSE_MULTIPLE = "/user/view/multiple";

	private static final String GET_USER_FAVOURITE_COURSE = "/user/entityType/{entityType}/transactionType/{transactionType}";
	
	private static final String FAVORITE_ENTITY_TYPE_EXIST = "/api/v1/favorite/{entityType}/exists";

	private static final String VIEW_TRANSACTION_COUNT = "/api/v1/transaction/user/entityType/{entityType}/transactionType/{transactionType}/count";
	
	private static final String MSG_ERROR_INVOKING = "Error invoking view transaction service";
	private static final String MSG_ERROR_CODE = "Error response recieved from view transaction service with error code ";
	private static final String MSG_ERROR_CODE_EXCEPTION = "Error response recieved from view transaction service with error code {}";
	
	public List<String> getUserViewEntityIds(final List<String> entityIds, final String userId,
			final EntityTypeEnum type) {
		ResponseEntity<GenericWrapperDto<List<String>>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTION_URL).append(GET_USER_VIEW_COURSE_MULTIPLE);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam(ENTITY_TYPE, type.name());
			uriBuilder.queryParam(TRANSACTION_TYPE, TransactionTypeEnum.VIEW.name());
			entityIds.stream().forEach(e -> uriBuilder.queryParam("entityIds", e));

			HttpHeaders header = new HttpHeaders();
			header.add(USER_ID, userId);

			HttpEntity<List<String>> body = new HttpEntity<>(null, header);

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, body,
					new ParameterizedTypeReference<GenericWrapperDto<List<String>>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE_EXCEPTION,
						responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}

	public List<UserMyCourseDto> getUserMyCourseByEntityIdAndTransactionType(String userId, String entityType,
			String transactionType) {
		ResponseEntity<GenericWrapperDto<List<UserMyCourseDto>>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		try {
			params.put(ENTITY_TYPE, entityType);
			params.put(TRANSACTION_TYPE, transactionType);

			HttpHeaders headers = new HttpHeaders();
			headers.set(USER_ID, userId);
			HttpEntity<String> entity = new HttpEntity<>(headers);

			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTION_URL).append(GET_USER_MY_COURSE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<UserMyCourseDto>>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE_EXCEPTION,
						responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}

	public List<UserMyCourseDto> getUserFavouriteCoursesByUserId(String userId) {
		Map<String, String> params = new HashMap<>();
		ResponseEntity<GenericWrapperDto<List<UserMyCourseDto>>> result = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTION_URL).append(GET_USER_FAVOURITE_COURSE);

			params.put(ENTITY_TYPE, EntityTypeEnum.COURSE.name());
			params.put(TRANSACTION_TYPE, TransactionTypeEnum.FAVORITE.name());

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(USER_ID, userId);
			HttpEntity<String> body = new HttpEntity<>(httpHeaders);
			result = restTemplate.exchange(path.toString(), HttpMethod.GET, body,
					new ParameterizedTypeReference<GenericWrapperDto<List<UserMyCourseDto>>>() {
					}, params);
			if (result.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE_EXCEPTION,
						result.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ result.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return result.getBody().getData();
	}

	public List<ViewTransactionDto> getAllUsersWhoMarkCourseFavorite(String userId, String courseId) {
		ResponseEntity<GenericWrapperDto<List<ViewTransactionDto>>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		try {
			params.put(ENTITY_TYPE, EntityTypeEnum.COURSE.name());
			params.put(TRANSACTION_TYPE, TransactionTypeEnum.FAVORITE.name());
			params.put(ENTTIY_ID, courseId);

			HttpHeaders headers = new HttpHeaders();
			headers.set(USER_ID, userId);
			HttpEntity<String> entity = new HttpEntity<>(headers);

			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTION_URL).append(GET_USERS_MARK_COURSE_FAVORITE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<ViewTransactionDto>>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException("Error response recieved from View transaction service with error code "
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}

	public UserViewCourseDto getUserViewedCourseByEntityIdAndTransactionType(String userId, String entityType,
			String entityId, String transactionType) {
		ResponseEntity<GenericWrapperDto<UserViewCourseDto>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		try {
			params.put(ENTITY_TYPE, entityType);
			params.put(TRANSACTION_TYPE, transactionType);
			params.put(ENTTIY_ID, entityId);

			HttpHeaders headers = new HttpHeaders();
			headers.set(USER_ID, userId);
			HttpEntity<String> entity = new HttpEntity<>(headers);

			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTION_URL).append(GET_USER_VIEW_COURSE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<UserViewCourseDto>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE_EXCEPTION,
						responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public TransactionCountDto getViewTransactionCount(String userId, String entityType, String transactionType) {
		ResponseEntity<GenericWrapperDto<TransactionCountDto>> transactionCountDtoResponse = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put(ENTITY_TYPE, entityType);
			params.put(TRANSACTION_TYPE, transactionType);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(USER_ID, userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTIONS_BASE_PATH).append(VIEW_TRANSACTION_COUNT);

			transactionCountDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<TransactionCountDto>>() {},params);
			if (transactionCountDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE_EXCEPTION,
						transactionCountDtoResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ transactionCountDtoResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return transactionCountDtoResponse.getBody().getData();
	}
	
	public boolean checkIfEntitySavedAsFavorite(String userId, EntityTypeEnum entityType) {
		ResponseEntity<GenericWrapperDto<TransactionExistsDto>> transactionCountDtoResponse = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put(ENTITY_TYPE, entityType.name());
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(USER_ID, userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			StringBuilder path = new StringBuilder();
			path.append(IConstant.VIEW_TRANSACTIONS_BASE_PATH).append(FAVORITE_ENTITY_TYPE_EXIST);

			transactionCountDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<TransactionExistsDto>>() {},params);
			if (transactionCountDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE_EXCEPTION,
						transactionCountDtoResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ transactionCountDtoResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return transactionCountDtoResponse.getBody().getData().isTransactionExists();
	}
}
