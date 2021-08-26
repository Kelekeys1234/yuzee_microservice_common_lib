package com.yuzee.common.lib.dto.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EventSyncDto {

	@JsonProperty("event_id")
	private String eventId;
	
	@JsonProperty("entity_id")
	private String entityId;
		
	@JsonProperty("entity_type")
	private String entityType;
	
	@JsonProperty("event_text")
	private String eventText;
	
}
