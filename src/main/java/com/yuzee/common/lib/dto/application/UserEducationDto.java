package com.yuzee.common.lib.dto.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.LevelDto;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.yuzee.common.lib.dto.user.SemesterDto;

import lombok.Data;

@Data
@Document
public class UserEducationDto {

	@JsonProperty("user_education_id")
	private UUID _id;

	@JsonProperty("institute_id")
	private String instituteId;

	@Column(name = "user_id")
	private String userId;

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

	@JsonProperty("education_system_id")
	public String educationSystemId;

	@JsonProperty("education_system_name")
	public String educationSystemName;

	@NotBlank(message = "course_name is required")
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

	@NotBlank(message = "study_mode is required")
	@JsonProperty("study_mode")
	private String studyMode;

	@JsonProperty("description")
	private String description;

	@NotBlank(message = "course_language is required")
	@JsonProperty("course_language")
	private String courseLanguage;

	@JsonProperty("institute_logo_url")
	private String instituteLogoUrl;

	@JsonProperty("level_id")
	private String levelId;

	@JsonProperty("latitude")
	private BigDecimal latitude;

	@JsonProperty("longitude")
	private BigDecimal longitude;

	@NotBlank(message = "result_type is required")
	@JsonProperty("result_type")
	private String resultType;

	@JsonProperty("level")
	private LevelDto level;

	@JsonProperty("source_user_education_id")
	private String sourceUserEducationId;

	@JsonProperty("semesters")
	List<SemesterDto> semesters = new ArrayList<>();

	@JsonProperty("certificates")
	List<StorageDto> certificates = new ArrayList<>();	
}