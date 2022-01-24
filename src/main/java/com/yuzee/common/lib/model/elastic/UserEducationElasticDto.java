package com.yuzee.common.lib.model.elastic;

import java.time.LocalDate;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserEducationElasticDto {
	
	@Field(name = "id")
	@JsonProperty("id")
	private String id;
	
	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@Field(name = "institute_id")
	@JsonProperty("institute_id")
	private String instituteId;
	
	@Field(name = "education_title")
	@JsonProperty("education_title")
	private String educationTitle;
	
	@Field(name = "city")
	@JsonProperty("city")
	private String city;
	
	@Field(name = "state")
	@JsonProperty("state")
	private String state;

	@Field(name = "country")
	@JsonProperty("country")
	private String country;
	
	@Field(name = "system")
	@JsonProperty("system")
	private String system;
	
	@Field(name = "institute_name")
	@JsonProperty("institute_name")
	private String instituteName;
	
	@Field(name = "course_name")
	@JsonProperty("course_name")
	private String courseName;

	@Field(name = "course_language")
	@JsonProperty("course_language")
	private String courseLanguage;

	@Field(name = "study_mode")
	@JsonProperty( "study_mode")
	private String studyMode;

	@Field(name = "description")
	@JsonProperty("description")
	private String description;

	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("start_date")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate start_date;
	
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("end_date")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate end_date;
	
	@Field(name = "cgpa")
	@JsonProperty( "cgpa")
	private double cgpa;
	
	@Field(name = "education_system_id")
	@JsonProperty("education_system_id")
	public String educationSystemId;
}	