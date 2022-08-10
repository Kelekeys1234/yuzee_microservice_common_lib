package com.yuzee.common.lib.model.elastic;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserAchivementsElasticDto {
	
	@Field(name = "id")
	@JsonProperty("id")
	private String id;

	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@Field(name = "title")
	@JsonProperty("title")
	private String achievementTitle;
	
	@Field(name = "year")
	@JsonProperty("year")
	private String year;
	
	@Field(name = "city")
	@JsonProperty("city")
	public String city;
	
	@Field(name = "country")
	@JsonProperty("country")
	public String country;
	
	@Field(name = "issuer_name")
	@JsonProperty("issuer_name")
	public String nameOfIssuer;
	
	@Field(name = "description")
	@JsonProperty("description")
	public String achievmentDetails;

}
