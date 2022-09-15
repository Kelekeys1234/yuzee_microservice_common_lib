package com.yuzee.common.lib.dto.institute;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.company.CompanyContactDetailDto;
import com.yuzee.common.lib.dto.review.ReviewStarDto;
import com.yuzee.common.lib.enumeration.InstituteType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class InstituteSyncDTO implements SyncDTO {

	@JsonProperty("institute_id")
	@NotBlank(message = "institute_id should not be blank")
	private String id;

	@JsonProperty("country_name")
	@NotBlank(message = "country_name should not be blank")
	private String countryName;
	
	@JsonProperty("postal_code")
	private Integer postalCode;

	@JsonProperty("city_name")
	@NotBlank(message = "city_name should not be blank")
	private String cityName;

	@JsonProperty("institute_type")
	private String instituteType;

	@JsonProperty("name")
	@NotBlank(message = "name should not be blank")
	private String name;

	@JsonProperty("world_ranking")
	private Integer worldRanking;

	@JsonProperty("domestic_ranking")
	private Integer domesticRanking;
	
	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;

	@JsonProperty("description")
	private String description;

	@JsonProperty("campus")
	private String campus;

	@JsonProperty("level_code")
	private List<String> levelCode;

	@JsonProperty("stars")
	private Integer stars;
	
	@JsonProperty("state")
	private String state;

	@JsonProperty("faculty_names")
	private List<String> facultyNames;

	@JsonProperty("intakes")
	private List<String> intakes;

	@JsonProperty("level_name")
	private List<String> levelName;

	@JsonProperty("tag_line")
	private String tagLine;
	
	@JsonProperty("is_active")
	private Boolean isActive;
	
	@JsonProperty("readable_id")
	private String readableId;

	@JsonProperty("institute_english_requirements")
	private List<InstituteEnglishRequirementsElasticDto> instituteEnglishRequirements;
	
	@JsonProperty("institute_facilities")
	private List<String> instituteFacilities;
	
	@JsonProperty("institute_services")
	private List<String> instituteServices;
	
	@JsonProperty("institute_intakes")
	private List<String> instituteIntakes;
	
	@JsonProperty("total_student")
	private Integer totalStudent;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("about_info")
	private String aboutInfo;
	
	@JsonProperty("website")
	private String website;

	@JsonProperty("logo_url")
	private String logoUrl;
	
	@JsonProperty("cover_photo_url")
	private String coverPhotoUrl;
	
	@JsonProperty("review_count")
	private ReviewStarDto reviewCount;
	
	@JsonProperty("contact_details")
	private List<CompanyContactDetailDto> contactDetails;

	@JsonProperty("provider_codes")
	private List<ProviderCodeDto> instituteProviderCodes;
	
	@JsonProperty("institute_type_obj")
	private InstituteType instituteTypeObj;
	
	@Override
	public String getIdentifier() {
		return this.getId();
	}
	
	@JsonProperty("verified")
	private boolean verified;
	
	@JsonProperty("is_domestic_application_enable")
	private Boolean isDomesticApplicationEnable;
	
	@JsonProperty("is_international_application_enable")
	private Boolean isInternationalApplicationEnable;
}
