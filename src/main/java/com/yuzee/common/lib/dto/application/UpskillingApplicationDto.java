package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UpskillingApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("application_id")
	private String id;
	
	@JsonProperty("education_details")
	private UserEducationDto userEducation;
	
	@JsonProperty("why_would_you_like_to_upskill")
	private String whyWouldYouLikeToUpsklll;
	
	@JsonProperty("currenly_working")
	private String currentlyWorking;
	
	@JsonProperty("study_time")
	private UserStudyTimeDto studyTime;
	
}
