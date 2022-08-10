package com.yuzee.common.lib.model.elastic;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserFutureMeElasticDto {
	
	@Field(name = "id")
	@JsonProperty("id")
	private String id;
		
	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@Field(name = "ideal_course")
	@JsonProperty("ideal_course")
	private List<String> idealCourse;
	
	@Field(name = "ideal_job")
	@JsonProperty("ideal_job")
	private List<String> idealJob;
	
	@Field(name = "ideal_field")
	@JsonProperty("ideal_field")
	private List<String> idealField;
	
	@Field(name = "ideal_location")
	@JsonProperty("ideal_location")
	private List<UserFutureMeIdealLocation> idealLocation;
	
	@Field(name = "description")
	@JsonProperty("description")
	private String description;
	

}
