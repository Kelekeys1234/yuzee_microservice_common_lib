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
	
	@JsonProperty("detail_description")
	@Field(name = "detail_description")
	private String detailDescription;
	
	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;
	
	@JsonProperty("employed_users")
	@Field(name = "employed_users", type = FieldType.Nested)
	private List<String> listOfEmployedUser = new ArrayList<>();
	
	@JsonProperty("relevent_courses")
	@Field(name = "relevent_courses", type = FieldType.Nested)
	private List<String> listOfReleventCourse = new ArrayList<>();
	
	@JsonProperty("skills")
	@Field(name = "skills", type = FieldType.Nested)
	private List<String> listOfSkill = new ArrayList<>();
}