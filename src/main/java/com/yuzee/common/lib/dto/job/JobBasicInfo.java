package com.yuzee.common.lib.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JobBasicInfo {
	
	@JsonProperty("job_id")
	private String id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("latitude")
	private Double latitude;
	
	@JsonProperty("longitude")
	private Double longitude;
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("entity_type")
	private String entityType;
	
	@JsonProperty("entity_name")
	private String entityName;
	
	@JsonProperty("logo_url")
	private String logoUrl;
	
	@JsonProperty("location")
	private String jobLocation;
	
}
