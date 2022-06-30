package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.interaction.CommentExportDto;
import com.yuzee.common.lib.dto.interaction.HasUserLikeDto;
import com.yuzee.common.lib.dto.interaction.InteractionCountDto;
import com.yuzee.common.lib.dto.interaction.VoteCommentCountDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConditionalOnProperty(name = "yuzee.interaction.enabled", havingValue = "true")
public class InteractionHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_NUMBER_OF_INTERACTION = IConstant.INTERACTION_CONNECTION_URL
			+ "/count/interaction/entityId/{entityId}";
	private static final String GET_NUMBER_OF_INTERACTION_FOR_EACH_ENTITY = IConstant.INTERACTION_CONNECTION_URL
			+ "/count/interaction";
	private static final String CHECK_IF_USER_LIKED_ENTITY = IConstant.INTERACTION_CONNECTION_URL
			+ "/user/{userId}/like/entityId/{entityId}";
	private static final String CHECK_IF_USER_LIKED_ENTITY_FOR_EACH_ENTITY = IConstant.INTERACTION_CONNECTION_URL
			+ "/user/{userId}/like/entityIds";
	private static final String GET_NUMBER_OF_VOTES_AND_COMMENT = IConstant.INTERACTION_CONNECTION_URL
			+ "/count/vote/comment/entityId/{entityId}";
	private static final String INTERACTION_BASE_URL = IConstant.INTERACTION_CONNECTION_URL + "/comment";
	private static final String MSG_ERROR_CODE = "Error response recieved from interaction service with error code ";
	private static final String MSG_ERROR_INVOKING = "Error invoking interaction service";
	private static final String USERID = "/userId";
	private static final String ENTITY_ID = "entityId";

	public InteractionCountDto getNumberOfInteraction(String entityId) {
		ResponseEntity<GenericWrapperDto<InteractionCountDto>> interactionCountDtoResponse = null;
		Map<String, String> params = new HashMap<>();
		params.put(ENTITY_ID, entityId);
		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_NUMBER_OF_INTERACTION);
			interactionCountDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<InteractionCountDto>>() {
					}, params);
			if (interactionCountDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + interactionCountDtoResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + interactionCountDtoResponse.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return interactionCountDtoResponse.getBody().getData();
	}

	public List<InteractionCountDto> getNumberOfInteraction(List<String> entityIds) {
		ResponseEntity<GenericWrapperDto<List<InteractionCountDto>>> interactionCountDtoResponse = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_NUMBER_OF_INTERACTION_FOR_EACH_ENTITY);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			entityIds.stream().forEach(e -> builder.queryParam(ENTITY_ID, e));

			interactionCountDtoResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<InteractionCountDto>>>() {
					});
			if (interactionCountDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + interactionCountDtoResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + interactionCountDtoResponse.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return interactionCountDtoResponse.getBody().getData();
	}

	public HasUserLikeDto checkIfUserHasLikedEntity(String userId, String entityId) {
		ResponseEntity<GenericWrapperDto<HasUserLikeDto>> hasUserLikeDtoResponse = null;
		Map<String, String> params = new HashMap<>();
		params.put("userId", userId);
		params.put(ENTITY_ID, entityId);
		try {
			StringBuilder path = new StringBuilder();
			path.append(CHECK_IF_USER_LIKED_ENTITY);
			hasUserLikeDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<HasUserLikeDto>>() {
					}, params);
			if (hasUserLikeDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + hasUserLikeDtoResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + hasUserLikeDtoResponse.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return hasUserLikeDtoResponse.getBody().getData();
	}

	public List<HasUserLikeDto> checkIfUserHasLikedEntity(String userId, List<String> entityIds) {
		ResponseEntity<GenericWrapperDto<List<HasUserLikeDto>>> hasUserLikeDtoResponse = null;
		Map<String, String> params = new HashMap<>();
		params.put("userId", userId);
		try {
			StringBuilder path = new StringBuilder();
			path.append(CHECK_IF_USER_LIKED_ENTITY_FOR_EACH_ENTITY);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			entityIds.stream().forEach(e -> builder.queryParam(ENTITY_ID, e));

			UriComponents components = builder.buildAndExpand(params);

			hasUserLikeDtoResponse = restTemplate.exchange(components.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<HasUserLikeDto>>>() {
					}, params);
			if (hasUserLikeDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + hasUserLikeDtoResponse.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + hasUserLikeDtoResponse.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return hasUserLikeDtoResponse.getBody().getData();
	}

	public VoteCommentCountDto getNumberOfVotesAndComment(String entityId) {
		ResponseEntity<GenericWrapperDto<VoteCommentCountDto>> voteCommentCountResponseDto = null;
		Map<String, String> params = new HashMap<>();
		params.put(ENTITY_ID, entityId);
		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_NUMBER_OF_VOTES_AND_COMMENT);
			voteCommentCountResponseDto = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<VoteCommentCountDto>>() {
					}, params);
			if (voteCommentCountResponseDto.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + voteCommentCountResponseDto.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + voteCommentCountResponseDto.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return voteCommentCountResponseDto.getBody().getData();
	}

	// "http://INTERACTION-SERVICE/interaction-service/api/v1/comment/userId"
	public List<CommentExportDto> getAllCommentsByUserId(String userId) {
		ResponseEntity<GenericWrapperDto<List<CommentExportDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(INTERACTION_BASE_URL).append(USERID).append("/").append(userId);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<CommentExportDto>>>() {
					});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
}
