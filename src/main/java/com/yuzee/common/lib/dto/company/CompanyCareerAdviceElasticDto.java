package com.yuzee.common.lib.dto.company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCareerAdviceElasticDto {

	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("detail_description")
	private String detailDescription;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@JsonProperty("employed_users")
	private List<String> listOfEmployedUser;
	
	@JsonProperty("relevent_courses")
	private List<String> listOfReleventCourse;
	
	@JsonProperty("skills")
	private List<String> listOfSkill;
}
