package com.yuzee.common.lib.dto.elastic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWorkExperienceElasticDto {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@JsonProperty("job_title")
	private String jobTitle;
	
	@JsonProperty("job_type")
	private String jobType;
	
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonProperty("start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@JsonProperty("end_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty( "country")
	private String country;
	
	@JsonProperty( "job_description")
	private String jobDescription;
	
	@JsonProperty("experience_entity_id")
	private String experienceEntityId;
	
	@JsonProperty( "experience_entity_type")
	private String experienceEntityType; 

}
