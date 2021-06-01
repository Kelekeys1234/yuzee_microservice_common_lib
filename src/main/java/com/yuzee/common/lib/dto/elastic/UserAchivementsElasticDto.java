package com.yuzee.common.lib.dto.elastic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAchivementsElasticDto {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("title")
	private String achievementTitle;
	
	@JsonProperty("year")
	private String year;
	
	@JsonProperty("city")
	public String city;
	
	@JsonProperty("country")
	public String country;
	
	@JsonProperty("issuer_name")
	public String nameOfIssuer;
	
	@JsonProperty("description")
	public String achievmentDetails;

}
