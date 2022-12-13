package com.yuzee.common.lib.dto.institute;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class InstituteBasicInfoDto {

	@JsonProperty("institute_logo_path")
	private String instituteLogoPath;

	@NotBlank(message = "name_of_university should not be blank")
	@JsonProperty("name_of_university")
	private String nameOfUniversity;
	
	@JsonProperty("business_account_type")
	private String businessAccountType;
	
	@JsonProperty("institute_affiliaction_type")
	private String instituteAffiliactionType;
	
	@JsonProperty("institute_type")
	@NotNull(message = "{institute_type.is_required}")
	private List<String> instituteType;

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
	
	@JsonProperty("postal_code")
	private Integer postalCode;

	public InstituteBasicInfoDto(String instituteLogoPath,
			@NotBlank(message = "name_of_university should not be blank") String nameOfUniversity,
			@NotBlank(message = "institute_category_type_id should not be blank") String instituteCategoryTypeId,
			@NotBlank(message = "institute_category_type_name should not be blank") String instituteCategoryTypeName,
			@NotBlank(message = "description should not be blank") String description, String countryName,
			String cityName, String stateName, String address, String createdBy, Integer worldRanking,
			Integer domesticRanking, Integer totalCourses, Double stars, Long reviewsCount, boolean verified) {
		super();
		this.instituteLogoPath = instituteLogoPath;
		this.nameOfUniversity = nameOfUniversity;
		this.instituteCategoryTypeId = instituteCategoryTypeId;
		this.instituteCategoryTypeName = instituteCategoryTypeName;
		this.description = description;
		this.countryName = countryName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.address = address;
		this.createdBy = createdBy;
		this.worldRanking = worldRanking;
		this.domesticRanking = domesticRanking;
		this.totalCourses = totalCourses;
		this.stars = stars;
		this.reviewsCount = reviewsCount;
		this.verified = verified;
	}

}