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
public class CompanyInternship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7001005089511752649L;

	@JsonProperty("company_internship_id")
	@Field(name = "id")
	private String id;

	@JsonProperty("title")
	@Field(name = "title")
	private String title;

	@JsonProperty("description")
	@Field(name = "description")
	private String description;

	@JsonProperty("education_need")
	@Field(name = "education_need")
	private String educationNeed;

	@JsonProperty("internship_members")
	@Field(name = "internship_members", type = FieldType.Nested)
	private List<String> internshipMembers = new ArrayList<>();

	@JsonProperty("internship_skills")
	@Field(name = "internship_skills", type = FieldType.Nested)
	private List<String> internshipSkills = new ArrayList<>();

}
