package com.yuzee.common.lib.dto.elastic;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLanguageQualificationElasticDto {


	@JsonProperty("id")
	private String id;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@JsonProperty("exam_name")
	private String examName;
	
	@JsonProperty("reading_marks")
	private double readingMarks;
	
	@JsonProperty("listning_marks")
	private double listningMarks;
	
	@JsonProperty("writing_marks")
	private double writingMarks;
	
	@JsonProperty("oral_marks")
	private double oralMarks;
	
	@JsonProperty("ovar_all_marks")
	private double overAllMarks;
}
