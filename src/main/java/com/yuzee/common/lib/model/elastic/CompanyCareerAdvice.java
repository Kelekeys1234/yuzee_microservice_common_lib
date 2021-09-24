package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCareerAdvice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8330706669461119390L;

	@JsonProperty("id")
	@Field(name = "id")
	private String id;

	@JsonProperty("title")
	@Field(name = "title")
	private String title;

	@JsonProperty("description")
	@Field(name = "description")
	private String description;

	@JsonProperty("company_employees")
	@Field(name = "company_employees", type = FieldType.Nested)
	private List<String> companyEmployees = new ArrayList<>();

	@JsonProperty("collaborations")
	@Field(name = "collaborations", type = FieldType.Nested)
	private List<String> collaborations = new ArrayList<>();

	@JsonProperty("company_preffered_courses")
	@Field(name = "company_preffered_courses", type = FieldType.Nested)
	private List<CompanyPreferredCourse> listOfCompanyPreferredCourse = new ArrayList<>();
}