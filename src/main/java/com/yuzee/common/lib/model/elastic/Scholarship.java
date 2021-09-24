package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("scholarship")
public class Scholarship implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("scholarship_id")
	@Field("id")
	private String id;

	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;

	@JsonProperty("entity_id")
	@Field(name = "entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	@Field(name = "entity_type")
	private String entityType;

	@JsonProperty("title")
	@Field(name = "title")
	private String title;

	@JsonProperty("description")
	@Field(name = "description")
	private String description;

	@JsonProperty("scholarship_validity")
	@Field(name = "scholarship_validity")
	private String scholarshipValidity;

	@JsonProperty("scholarship_coverage")
	@Field(name = "scholarship_coverage")
	private String scholarshipCoverage;

	@JsonProperty("scholarship_award")
	@Field(name = "scholarship_award")
	private String scholarshipAward;

	@JsonProperty("currency")
	@Field(name = "currency")
	private String currency;

	@JsonProperty("scholarship_amount")
	@Field(name = "scholarship_amount")
	private Double scholarshipAmount;

	@JsonProperty("other_coverage")
	@Field(name = "other_coverage")
	private String otherCoverage;

	@JsonProperty("gender")
	@Field(name = "gender")
	private Gender gender;

	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("application_dead_line")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate applicationDeadLine;
	
	@JsonProperty("general_requirements")
	@Field(name = "general_requirements")
	private String generalRequirements;

	@JsonProperty("eligible_nationality")
	@Field(name = "eligible_nationality")
	private Set<String> eligbleNationality;

	@JsonProperty("how_to_apply")
	@Field(name = "how_to_apply")
	private String howToApply;

	@JsonProperty("benefits")
	@Field(name = "benefits")
	private String benefits;

	@JsonProperty("conditions")
	@Field(name = "conditions")
	private String conditions;

	@JsonProperty("successful_candidate_requirment")
	@Field(name = "successful_candidate_requirment")
	private String successfulCandidateRequirment;

	@Field(name = "eligible_country", type = FieldType.Nested)
	@JsonProperty("eligible_country")
	private Set<String> eligibleCountry;

	@Field(name = "eligible_level", type = FieldType.Nested)
	@JsonProperty("eligible_level")
	private Set<String> eligibleLevel;

	@Field(name = "eligible_entity", type = FieldType.Nested)
	@JsonProperty("eligible_entity")
	private List<ScholarshipEligibleEntity> listOfScholarshipEligibleEntity = new ArrayList<>();

	@Field(name = "required_languages", type = FieldType.Nested)
	@JsonProperty("reuquired_languages")
	private Set<String> requiredLanguages;

	@Field(name = "scholarship_application_deadline", type = FieldType.Nested)
	@JsonProperty("scholarship_application_deadline")
	private List<ScholarshipApplicationDeadline> listOfScholarshipApplicationDeadline = new ArrayList<>();
}
