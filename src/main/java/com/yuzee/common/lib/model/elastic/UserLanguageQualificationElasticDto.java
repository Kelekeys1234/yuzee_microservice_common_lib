package com.yuzee.common.lib.model.elastic;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLanguageQualificationElasticDto {

	@Field(name = "id")
	@JsonProperty("id")
	private String id;
	
	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@Field(name = "exam_name")
	@JsonProperty("exam_name")
	private String examName;
	
	@Field(name = "reading_marks")
	@JsonProperty("reading_marks")
	private double readingMarks;
	
	@Field(name = "listning_marks")
	@JsonProperty("listning_marks")
	private double listningMarks;
	
	@Field(name = "writing_marks")
	@JsonProperty("writing_marks")
	private double writingMarks;
	
	@Field(name = "oral_marks")
	@JsonProperty("oral_marks")
	private double oralMarks;
	
	@Field(name = "ovar_all_marks")
	@JsonProperty("ovar_all_marks")
	private double overAllMarks;
}
