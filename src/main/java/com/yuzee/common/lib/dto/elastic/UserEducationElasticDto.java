package com.yuzee.common.lib.dto.elastic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEducationElasticDto {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("institute_id")
	private String instituteId;
	
	@JsonProperty("education_title")
	private String educationTitle;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;
	
	@JsonProperty("system")
	private String system;
	
	@JsonProperty("institute_name")
	private String instituteName;
	
	@JsonProperty("course_name")
	private String courseName;

	@JsonProperty("course_language")
	private String courseLanguage;

	@JsonProperty( "study_mode")
	private String studyMode;

	@JsonProperty("description")
	private String description;

	@JsonProperty("start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@JsonProperty("end_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@JsonProperty( "cgpa")
	private String cgpa;

}
