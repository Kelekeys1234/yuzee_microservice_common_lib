package com.yuzee.common.lib.dto.elastic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFutureMeElasticDto {
	
	@JsonProperty("id")
	private String id;
		
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("ideal_course")
	private List<String> idealCourse;
	
	@JsonProperty("ideal_field")
	private List<String> idealField;
	
	@JsonProperty("ideal_job")
	private List<String> idealJob;
	
	@JsonProperty("ideal_location")
	private List<UserFutureMeIdealLocation> idealLocation;
	
	@JsonProperty("description")
	private String description;
	

}
