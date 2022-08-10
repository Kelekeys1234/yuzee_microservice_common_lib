package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3003883378769918501L;
	
	@JsonProperty("company_location_id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;
	
	@JsonProperty("campus_name")
	@Field(name = "name")
	private String name;
	
	@JsonProperty("address")
	@Field(name = "address")
	private String address;
	
	@JsonProperty("city_name")
	@Field(name = "city")
	private String city;
	
	@JsonProperty("state_name")
	@Field(name = "state")
	private String state;
	
	@JsonProperty("country_name")
	@Field(name = "country")
	private String country;
	
	@JsonProperty("postal_code")
	@Field(name = "postal_code")
	private String postalCode;
	
	@JsonProperty("latitude")
	@Field(name = "latitude")
	private Double latitude;
	
	@JsonProperty("longitude")
	@Field(name = "longitude")
	private Double longitude;
	
	@JsonProperty("is_primary")
	@Field(name = "is_head_quarter")
	private Boolean isHeadQuarter;
}
