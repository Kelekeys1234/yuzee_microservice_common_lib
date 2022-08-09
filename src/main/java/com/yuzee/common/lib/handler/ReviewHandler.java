package com.yuzee.common.lib.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

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
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.CountDto;
import com.yuzee.common.lib.dto.GenericResponse;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.review.AvgEndorsmentDto;
import com.yuzee.common.lib.dto.review.EndosermentExistsDto;
import com.yuzee.common.lib.dto.review.ReviewStarDto;
import com.yuzee.common.lib.dto.review.SkillEndorsementDto;
import com.yuzee.common.lib.exception.BaseRuntimeException;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.review-handler.enabled", havingValue = "true")
public class ReviewHandler {

	private static final String GET_USER_AVERAGE_REVIEW = "/user/review/average/entityType/{entityType}";

	private static final String INVOKE_EXCEPTION = "Error invoking review service";

	private static final String INVALID_STATUS_CODE_EXCEPTION = "Error response recieved from review service with error code ";

	private static final String ENDORSEMENT_EXISTS_BY_TARGET_USER_ID = "/api/v1/endorsement/user/id/{targetUserId}/exists";

	private static final String ENDORSEMENT_EXISTS_BY_ENDORSED_BY_USER_ID = "/api/v1/endorsement/endorsed/user/id/{endorsedByUserId}/exists";

	private static final String AVERAGE_ENDORSEMENT = "/api/v1/endorsement/average";

	private static final String GET_ENDORSEMENTS_BY_TARGET_USER_ID = "/api/v1/endorsement/user/id/{targetUserId}";

	private static final String UPDATE_NETWORK_CATEGORY_USER_REVIEW = "/api/v1/user/review/entityType/{entityType}/entityId/{entityId}";

	private static final String DELETE_USER_REVIEW = "/api/v1/user/review";
	
	private static final String GET_REVIEW_COUNT_BY_ENTITY_ID_AND_ENTITY_TYPE = "/api/v1/user/review/count/entityType/{entityType}/entityId/{entityId}"; 

	@Autowired
	private RestTemplate restTemplate;

	// api for calculating user review average
	public Map<String, ReviewStarDto> getAverageReview(String entityType, List<String> entityIds) {
		ResponseEntity<GenericWrapperDto<List<ReviewStarDto>>> responseEntity = null;
		Map<String, ReviewStarDto> map = new HashMap<>();
		if (CollectionUtils.isEmpty(entityIds)) {
			return map;
		}
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_CONNECTION_URL).append(GET_USER_AVERAGE_REVIEW);
			Map<String, String> urlParams = new HashMap<>();
			urlParams.put("entityType", entityType);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			entityIds.stream().forEach(e -> uriBuilder.queryParam("entityIds", e));

			responseEntity = restTemplate.exchange(uriBuilder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<ReviewStarDto>>>() {
					});

			if (responseEntity.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}

		List<ReviewStarDto> dtos = responseEntity.getBody().getData();
		if (!CollectionUtils.isEmpty(dtos)) {
			map = dtos.stream().collect(Collectors.toMap(ReviewStarDto::getEntityId, e -> e));
		}
		return map;
	}

	public EndosermentExistsDto checkEndorsementExistsByTargetUserID(String targetUserId) {
		ResponseEntity<GenericWrapperDto<EndosermentExistsDto>> transactionCountDtoResponse = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put("targetUserId", targetUserId);

			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_BASE_PATH).append(ENDORSEMENT_EXISTS_BY_TARGET_USER_ID);

			transactionCountDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<EndosermentExistsDto>>() {
					}, params);
			if (transactionCountDtoResponse.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + transactionCountDtoResponse.getStatusCode().value());
				throw new InvokeException(
						INVALID_STATUS_CODE_EXCEPTION + transactionCountDtoResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return transactionCountDtoResponse.getBody().getData();
	}

	public EndosermentExistsDto checkEndorsementExistsByEndorsedByUserID(String endorsedByUserId) {
		ResponseEntity<GenericWrapperDto<EndosermentExistsDto>> transactionCountDtoResponse = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put("endorsedByUserId", endorsedByUserId);

			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_BASE_PATH).append(ENDORSEMENT_EXISTS_BY_ENDORSED_BY_USER_ID);

			transactionCountDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<EndosermentExistsDto>>() {
					}, params);
			if (transactionCountDtoResponse.getStatusCode().value() != 200) {
				throw new InvokeException("Error response recieved from View Transaction service with error code "
						+ transactionCountDtoResponse.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return transactionCountDtoResponse.getBody().getData();
	}

	public List<AvgEndorsmentDto> getAvgEndorsements(String userId, List<String> skills) {
		ResponseEntity<GenericWrapperDto<List<AvgEndorsmentDto>>> responseEntity = null;

		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId);
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_BASE_PATH).append(AVERAGE_ENDORSEMENT);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			skills.stream().forEach(e -> {
				try {
					uriBuilder.queryParam("skill_name", URLEncoder.encode(e, "UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					log.error("error while encoding skill names", e);
					throw new BaseRuntimeException(e1);
				}
			});

			HttpEntity<String> entity = new HttpEntity<>("", headers);

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<AvgEndorsmentDto>>>() {
					});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return responseEntity.getBody().getData();
	}

	public List<SkillEndorsementDto> getEndorsementsByTargetUserId(String loginUserId, String targetUserId) {
		ResponseEntity<GenericWrapperDto<List<SkillEndorsementDto>>> responseEntity = null;

		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", loginUserId);
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, String> params = new HashMap<>();
		params.put("targetUserId", targetUserId);
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_BASE_PATH).append(GET_ENDORSEMENTS_BY_TARGET_USER_ID);

			HttpEntity<String> entity = new HttpEntity<>("", headers);

			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<SkillEndorsementDto>>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return responseEntity.getBody().getData();
	}

	public GenericResponse updateNetworkCategoryInUserReview(String userId, String entityType, String entityId,
			String category) {
		ResponseEntity<GenericResponse> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		params.put("entityType", entityType);
		params.put("entityId", entityId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId);
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_BASE_PATH).append(UPDATE_NETWORK_CATEGORY_USER_REVIEW);

			HttpEntity<String> body = new HttpEntity<>("", headers);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("networkCategory", category);
			
			responseEntity = restTemplate.exchange(uriBuilder.buildAndExpand(params).toUriString(), HttpMethod.PUT, body, GenericResponse.class,
					params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return responseEntity.getBody();
	}

	public GenericResponse deleteUserReviewByEntityIds(String userId, Map<String,List<String>> entityIds) {
		ResponseEntity<GenericResponse> responseEntity = null;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.REVIEW_BASE_PATH).append(DELETE_USER_REVIEW);
			
			HttpEntity<Map<String,List<String>>> body = new HttpEntity<>(entityIds, headers);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.DELETE, body, GenericResponse.class);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return responseEntity.getBody();
	}
	
	public CountDto getReviewCountByEntityIdAndEntityType(String entityId, String entityType){
		ResponseEntity<GenericWrapperDto<CountDto>> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			Map<String, String> params = new HashMap<>();
			params.put("entityId", entityId);
			params.put("entityType", entityType);
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.REVIEW_BASE_PATH).append(GET_REVIEW_COUNT_BY_ENTITY_ID_AND_ENTITY_TYPE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<CountDto>>() {}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException(INVOKE_EXCEPTION);
		}
		return responseEntity.getBody().getData();
	}
}
