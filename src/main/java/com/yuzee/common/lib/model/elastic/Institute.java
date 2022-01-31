package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.InstituteTimingElasticDto;

import lombok.Data;

@Data
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("institute")
public class Institute implements Serializable {
	
	private static final long serialVersionUID = -5791958611869275106L;

	@Id
	@Field(name = "institute_id")
	@JsonProperty("institute_id")
	private String id;
	
	@JsonProperty("country_name")
	@Field(name = "country_name")
	private String countryName;
	
	@JsonProperty("city_name")
	@Field(name = "city_name")
	private String cityName;
	
	@JsonProperty("institute_type")
	@Field(name = "institute_type")
	private String instituteType;
	
	@JsonProperty("name")
	@Field(name = "name")
	private String name;
	
	@JsonProperty("world_ranking")
	@Field(name = "world_ranking")
	private Integer worldRanking;
	
	@JsonProperty("latitude")
	@Field(name = "latitude")
	private Double latitude;
	
	@JsonProperty("longitude")
	@Field(name = "longitude")
	private Double longitude;
	
	@JsonProperty("description")
	@Field(name = "description")
	private String description;
	
	@JsonProperty("state")
	@Field(name = "state")
	private String state;
	
	@Field(name = "postal_code")
	@JsonProperty("postal_code")
	private Integer postalCode;
	
	@JsonProperty("intakes")
	@Field(name = "institute_intakes")
	private List<String> intakes;
	
	@JsonProperty("domestic_ranking")
	@Field(name = "domestic_ranking")
	private Integer domesticRanking;
	
	@JsonProperty("total_student")
	@Field(name = "total_student")
	private Integer totalStudent;
	
	@JsonProperty("email")
	@Field(name = "email")
	private String email;
	
	@JsonProperty("address")
	@Field(name = "address")
	private String address;
	
	@JsonProperty("about_info")
	@Field(name = "about_info")
	private String aboutInfo;
	
	@JsonProperty("website")
	@Field(name = "website")
	private String website;
	
	@JsonProperty("institute_timings")
	@Field(name = "institute_timings")
	private List<InstituteTimingElasticDto> instituteTimings=new ArrayList<>();

	@JsonProperty("is_active")
	@Field(name = "is_active")
	private Boolean isActive;

	@JsonProperty("readable_id")
	@Field(name = "readable_id")
	private String readableId;
	
	@JsonProperty("contact_details")
	@Field(name = "contact_details", type = FieldType.Nested)
	private List<ContactDetail> contactDetails = new ArrayList<>();
	
	@JsonProperty("provider_codes")
	@Field(name = "provider_codes", type = FieldType.Nested)
	private List<ProviderCode> providerCodes = new ArrayList<>();
	
	@JsonProperty("verified")
	@Field(name = "verified")
	private Boolean verified = false;
	
	@JsonProperty("is_domestic_application_enalbe")
	@Field(name = "is_domestic_application_enalbe")
	private Boolean isDomesticApplicationEnable = false;
	
	@JsonProperty("is_international_application_enalbe")
	@Field(name = "is_international_application_enalbe")
	private Boolean isInternationalApplicationEnable = false;
}
