package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
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

	@JsonProperty("company_employees")
	private List<String> listOfCompanyEmployee = new ArrayList<>();

	@JsonProperty("collaborations")
	private List<String> listOfCompanyCareerAdviceCollaboration = new ArrayList<>();

	@JsonProperty("company_preffered_courses")
	private List<CompanyPreferredCourseElasticDto> listOfCompanyPreferredCourse = new ArrayList<>();
}
