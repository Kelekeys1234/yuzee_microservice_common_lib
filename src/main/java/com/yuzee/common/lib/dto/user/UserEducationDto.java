package com.yuzee.common.lib.dto.user;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.SubjectDto;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEducationDto {

	@JsonProperty("user_education_id")
	private String userEducationId;

	@JsonProperty("institute_id")
	private String instituteId;

	@NotBlank(message = "privacy_level is required")
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@NotBlank(message = "education_title is required")
	@JsonProperty("education_title")
	private String educationTitle;

	@NotBlank(message = "institute_name is required")
	@JsonProperty("institute_name")
	private String instituteName;

	@NotBlank(message = "city is required")
	@JsonProperty("city")
	private String city;

	@NotBlank(message = "state is required")
	@JsonProperty("state")
	private String state;

	@NotBlank(message = "postal_code is required")
	@JsonProperty("postal_code")
	private String postalCode;
	
	@NotBlank(message = "country is required")
	@JsonProperty("country")
	public String country;

	@JsonProperty("system")
	public String system;

	@JsonProperty("course_name")
	public String courseName;

	@JsonProperty("cgpa")
	public double cgpa;

	@NotNull(message = "start_date is required")
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("start_date")
	private Date startDate;

	@JsonProperty("end_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;

	@JsonProperty("study_mode")
	private String studyMode;

	@JsonProperty("description")
	private String description;

	@JsonProperty("course_language")
	private String courseLanguage;

	@JsonProperty("institute_logo_url")
	private String instituteLogoUrl;

	List<SubjectDto> subjects = new ArrayList<>();

	List<StorageDto> certificates = new ArrayList<>();	
}
