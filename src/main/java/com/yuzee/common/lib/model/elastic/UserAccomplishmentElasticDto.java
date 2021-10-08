package com.yuzee.common.lib.model.elastic;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccomplishmentElasticDto {
	
	@Field(name = "id")
	@JsonProperty("id")
	public String id;
	
	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	public String privacyLevel;
	
	@Field(name = "user_accomplishment_type")
	@JsonProperty("user_accomplishment_type")
	public String userAccomplishmentType;
	
	@Field(name = "language_proficiency_type")
	@JsonProperty("language_proficiency_type")
	public String languageProficiencyType;
	
	@Field(name = "title")
	@JsonProperty("title")
	private String title;
	
	@Field(name = "position_help")
	@JsonProperty("position_help")
	private String positionHelp;
	
	@Field(name = "score")
	@JsonProperty("score")
	private double score;
	
	@Field(name = "is_current")
	@JsonProperty("is_current")
	private boolean current;
	
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	@JsonProperty("start_date")
	private LocalDate startDate;
	
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	@JsonProperty("end_date")
	private LocalDate endDate;
	
	@Field(name = "issuer")
	@JsonProperty("issuer")
	private String issuer;
	
	@Field(name = "associated_with")
	@JsonProperty("associated_with")
	private String associatedWith;
	
	@Field(name = "associated_with_entity_id")
	@JsonProperty("associated_with_entity_id")
	private String associatedWithEntityId;
	
	@Field(name = "associated_with_type")
	@JsonProperty("associated_with_type")
	private String associatedWithType;
	
	@Field(name = "country")
	@JsonProperty("country")
	private String country;
	
	@Field(name = "identifier")
	@JsonProperty("identifier")
	private String identifier;
	
	@Field(name = "publication")
	@JsonProperty("publication")
	private String publication;
	
	@Field(name = "url")
	@JsonProperty("url")
	private String url;
	
	@Field(name = "patent_status")
	@JsonProperty("patent_status")
	private String patentStatus;
	
	@Field(name = "collaborators")
	@JsonProperty("collaborators")
	private Set<String> collaborators=new HashSet<>();
	
	@Field(name = "description")
	@JsonProperty("description")
	private String description;
} 