package com.yuzee.common.lib.handler;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
import com.yuzee.common.lib.dto.interaction.TagDto;
import com.yuzee.common.lib.dto.post.MediaFeedDto;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.post-handler.enabled", havingValue = "true")
public class PostHandler {

	private static final String GET_POST_BY_ID = "/post/multiple/id";
	
	private static final String HASHTAG = "/hashtag";

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String MSG_ERROR_CODE = "Error response recieved from Post service with error code ";
	private static final String MSG_ERROR_INVOKING = "Error invoking Post service";

	public List<MediaFeedDto> getPosts(String userId, List<String> postIds, EntityTypeEnum postType) throws InvokeException {
		ResponseEntity<GenericWrapperDto<List<MediaFeedDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.POST_URL).append(GET_POST_BY_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			postIds.stream().forEach(e -> uriBuilder.queryParam("post_id", e));
			uriBuilder.queryParam("type", postType);
			HttpHeaders headers = new HttpHeaders();
			headers.put("userId", Arrays.asList(userId));
			HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, requestEntity, new ParameterizedTypeReference<GenericWrapperDto<List<MediaFeedDto>>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE +
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
	
	public List<TagDto> addHashTag(String userId, Set<String> tags){
		ResponseEntity<GenericWrapperDto<List<TagDto>>> responseEntity;
		HttpHeaders headers = new HttpHeaders();
		headers.put("userId", Arrays.asList(userId));
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			StringBuilder path = new StringBuilder();
			path.append(IConstant.POST_URL).append(HASHTAG);

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			tags.stream().forEach(t -> builder.queryParam("tag_text", t));
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, new ParameterizedTypeReference<GenericWrapperDto<List<TagDto>>>() {});

			if(responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + responseEntity.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + responseEntity.getStatusCode().value() );
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
}
