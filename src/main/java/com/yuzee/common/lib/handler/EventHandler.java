package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yuzee.common.lib.dto.event.EventDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.event-handler.enabled", havingValue = "true")
public class EventHandler {
	
	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_EVENT_BY_ID = IConstant.EVENT_CONNECTION_URL + "/event/{eventId}";
	
	private static final String GET_EVENT_BY_MULTIPEL_ID = "/event/multiple/id";
	
	private static final String MSG_ERROR_CODE = "Error response recieved from event service with error code ";
	private static final String MSG_ERROR_INVOKING = "Error invoking event service";
	
	public EventDto getEventById(String eventId) throws InvokeException  {
		log.info("Get event info for id {}", eventId);
		ResponseEntity<GenericWrapperDto<EventDto>> eventDtoResponse = null;
		Map<String, String> params = new HashMap<>();
	    params.put("eventId", eventId);
		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_EVENT_BY_ID);
			eventDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<EventDto>>() {}, params);
			if (eventDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + eventDtoResponse.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + eventDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING,e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return eventDtoResponse.getBody().getData();
		
	}
	
	public List<EventDto> getEvents(List<String> eventIds) throws InvokeException {
		ResponseEntity<GenericWrapperDto<List<EventDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.EVENT_CONNECTION_URL).append(GET_EVENT_BY_MULTIPEL_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			eventIds.stream().forEach(e -> uriBuilder.queryParam("event_id", e));
			
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<List<EventDto>>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + responseEntity.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING,e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
}
