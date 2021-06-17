package com.yuzee.common.lib.dto.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyLocationDto {
	
	@JsonProperty("company_location_id")
	private String companyLocationId;
	
	@JsonProperty("icon")
	private StorageDto icon;
	
	@NotBlank(message = "privacy_level should not be null/blank")
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@NotBlank(message = "campus_name should not be null/blank")
	@JsonProperty("campus_name")
	private String campusName;

	@JsonProperty("city_name")
	@NotBlank(message = "city_name should not be null/blank")
	private String cityName;
	
	@JsonProperty("state_name")
	@NotBlank(message = "state_name should not be null/blank")
	private String stateName;
	
	@JsonProperty("country_name")
	@NotBlank(message = "country_name should not be null/blank")
	private String countryName;
	
	@JsonProperty("postal_code")
	@NotBlank(message = "postal_code should not be null/blank")
	private String postalCode;
	
	@JsonProperty("address")
	@NotBlank(message = "address should not be null/blank")
	private String address;
	
	@JsonProperty("latitude")
	@NotNull(message = "longitude should not be null")
	private Double latitude;
	
	@JsonProperty("longitude")
	@NotNull(message = "longitude should not be null")
	private Double longitude;
	
	@JsonProperty("is_primary")
	private Boolean isPrimary;
	
	@JsonProperty("is_Admin")
	private Boolean isAdmin;
	
	public CompanyLocationDto(String companyLocationId,
			@NotBlank(message = "campus_name should not be null/blank") String campusName,
			@NotBlank(message = "city_name should not be null/blank") String cityName,
			@NotBlank(message = "state_name should not be null/blank") String stateName,
			@NotBlank(message = "country_name should not be null/blank") String countryName,
			@NotBlank(message = "postal_code should not be null/blank") String postalCode,
			@NotBlank(message = "address should not be null/blank") String address,
			@NotNull(message = "longitude should not be null") Double latitude,
			@NotNull(message = "longitude should not be null") Double longitude, Boolean isPrimary,
			String privacyLevel,Boolean isAdmin) {
		super();
		this.companyLocationId = companyLocationId;
		this.campusName = campusName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
		this.postalCode = postalCode;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.isPrimary = isPrimary;
		this.privacyLevel = privacyLevel;
		this.isAdmin = isAdmin;
	}
}