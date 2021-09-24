package com.yuzee.common.lib.model.elastic;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserWorkExperienceElasticDto {
	
	@Field(name = "id")
	@JsonProperty("id")
	private String id;
	
	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@Field(name = "job_title")
	@JsonProperty("job_title")
	private String jobTitle;
	
	@Field(name = "job_type")
	@JsonProperty("job_type")
	private String jobType;
	
	@Field(name = "company_name")
	@JsonProperty("company_name")
	private String companyName;
	
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("start_date")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate startDate;
	
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("end_date")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate endDate;
	
	@Field(name = "city")
	@JsonProperty("city")
	private String city;
	
	@Field(name = "state")
	@JsonProperty("state")
	private String state;
	
	@Field(name = "country")
	@JsonProperty( "country")
	private String country;
	
	@Field(name = "job_description")
	@JsonProperty( "job_description")
	private String jobDescription;
	
	@Field(name = "experience_entity_id")
	@JsonProperty("experience_entity_id")
	private String experienceEntityId;
	
	@Field(name = "experience_entity_type")
	@JsonProperty( "experience_entity_type")
	private String experienceEntityType; 

}
