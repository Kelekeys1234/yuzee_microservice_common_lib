package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InstituteBasicInfoDto {

	@JsonProperty("institute_logo_path")
	private String instituteLogoPath;
	
	@NotBlank(message = "name_of_university should not be blank")
	@JsonProperty("name_of_university")
	private String nameOfUniversity;
	
	@NotBlank(message = "institute_category_type_id should not be blank")
	@JsonProperty("institute_category_type_id")
	private String instituteCategoryTypeId;
	
	@NotBlank(message = "institute_category_type_name should not be blank")
	@JsonProperty("institute_category_type_name")
	private String instituteCategoryTypeName;
	
	@NotBlank(message = "description should not be blank")
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("country_name")
	private String countryName;
	
	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("state_name")
	private String stateName;
	
	@JsonProperty("address")
	private String address;

	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("world_ranking")
	private Integer worldRanking;

	@JsonProperty("domestic_ranking")
	private Integer domesticRanking;
	
	@JsonProperty("total_courses")
	private Integer totalCourses;
	
	@JsonProperty("stars")
	private Double stars;
	
	@JsonProperty("reviews_count")
	private Long reviewsCount;
	
	@JsonProperty("verified")
	private boolean verified;
}