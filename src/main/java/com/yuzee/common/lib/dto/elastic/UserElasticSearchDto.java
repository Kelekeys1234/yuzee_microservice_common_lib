package com.yuzee.common.lib.dto.elastic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserElasticSearchDto {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;

	private String instituteName;
	private String courseName;
	
	@JsonProperty("country_orgin")
	private String countryOrgin;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	private Integer mutualCount;
	private Boolean isConnectionExist;
	private String imageURL;
	private List<UserRoleDto> roles;
	
	@JsonProperty("verified")
	private boolean verified;

	@JsonProperty("user_educations")
	private List<UserEducationElasticDto> userEducation;
}
