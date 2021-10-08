package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Timing implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("timing_id")
	@Field("id")
	private String id;

	@JsonProperty("timing_type")
	@Field("timing_type")
	private String timingType;

	@JsonProperty("entity_type")
	@Field("entity_type")
	private String entityType;

	@JsonProperty("entity_id")
	@Field("entity_id")
	private String entityId;

	@JsonProperty("monday")
	@Field("monday")
	private String monday = "CLOSED";

	@JsonProperty("tuesday")
	@Field("tuesday")
	private String tuesday = "CLOSED";

	@JsonProperty("wednesday")
	@Field("wednesday")
	private String wednesday = "CLOSED";

	@JsonProperty("thursday")
	@Field("thursday")
	private String thursday = "CLOSED";

	@JsonProperty("friday")
	@Field("friday")
	private String friday = "CLOSED";

	@JsonProperty("saturday")
	@Field("saturday")
	private String saturday = "CLOSED";

	@JsonProperty("sunday")
	@Field("sunday")
	private String sunday = "CLOSED";
}
