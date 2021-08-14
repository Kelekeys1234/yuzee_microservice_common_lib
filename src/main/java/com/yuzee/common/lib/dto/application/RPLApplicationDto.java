package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RPLApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("education_details")
	private UserEducationDto userEducation;
	
	@JsonProperty("study_time")
	private UserStudyTimeDto studyTime;
	
}

