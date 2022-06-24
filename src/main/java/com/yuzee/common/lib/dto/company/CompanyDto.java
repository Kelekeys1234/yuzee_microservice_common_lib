package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class CompanyDto {
	
	@JsonProperty(value ="company_id")
	String id;
	
	@NotEmpty(message = "company_type can not be null / empty")
	@JsonProperty("company_type")
	private String companyType;
	
	@NotEmpty(message = "company_sub_type can not be null / empty")
	@JsonProperty("company_sub_type")
	private String companySubType;
	
	@NotEmpty(message = "company_name can not be null / empty")
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonProperty("readable_id")
	private String readableId;
	
	@NotEmpty(message = "tag_line can not be null / empty")
	@JsonProperty("tag_line")
	private String tagLine;
	
	@NotEmpty(message = "description can not be null / empty")
	@JsonProperty("description")
	private String description;
	
	@NotEmpty(message = "public_url can not be null / empty")
	@JsonProperty("public_url")
	private String publicUrl;
	
	@NotEmpty(message = "industry can not be null / empty")
	@JsonProperty("industry")
	private String industry;
	
	@NotEmpty(message = "industry_type can not be null / empty")
	@JsonProperty("industry_type")
	private String industryType;
	
	@NotNull(message = "year_founded can not be null / empty")
	@JsonProperty("year_founded")
	private Integer yearFounded;
	
	@JsonProperty("speciality")
	@Valid
	@NotNull(message = "speciality can not be null / empty")
	private List<CompanySpecialityDto> specialitys = new ArrayList<>();
	
	@JsonProperty("locations")
	@Valid
	@NotNull(message = "locations can not be null / empty")
	private List<CompanyLocationDto> locations = new ArrayList<>();
	
	@JsonProperty("contact_details")
	@Valid
	@NotNull(message = "contact_details can not be null / empty")
	private List<CompanyContactDetailDto> contactDetails = new ArrayList<>();
	
	
	@JsonProperty("provider_code")
	@Valid
	@NotNull(message = "provider_code can not be null / empty")
	private List<CompanyProviderCodeDto> companyProviderCodeDtos = new ArrayList<>();
	
	@JsonProperty("profile_pic_url")
	private String profilePicUrl;
	
	@JsonProperty("cover_photo_url")
	private String coverPhotoUrl;
	
	@JsonProperty("is_admin")
	private Boolean isAdmin;

	@NotNull(message = "privacy_level can not be null / empty")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("rating")
	private Double rating;
	
	@JsonProperty("working_hours")
	List<CompanyWorkingHoursDto> workingHours = new ArrayList<>();
	
	@JsonProperty("is_verified")
	private boolean isVerified;
	
	@JsonProperty("australian_business_number")
	private String australianBusinessNumber;
	
	@JsonProperty("storages")
	private List<StorageDto> storages;
	
}