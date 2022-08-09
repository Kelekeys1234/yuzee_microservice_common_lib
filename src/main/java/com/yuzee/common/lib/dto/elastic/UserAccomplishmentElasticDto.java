package com.yuzee.common.lib.dto.elastic;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccomplishmentElasticDto {
	
	@JsonProperty("id")
	public String id;
	
	@JsonProperty("privacy_level")
	public String privacyLevel;
	
	@JsonProperty("user_accomplishment_type")
	public String userAccomplishmentType;
	
	@JsonProperty("language_proficiency_type")
	public String languageProficiencyType;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("position_help")
	private String positionHelp;
	
	@JsonProperty("score")
	private double score;
	
	@JsonProperty("is_current")
	private boolean current;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("start_date")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("end_date")
	private Date endDate;
	
	@JsonProperty("issuer")
	private String issuer;
	
	@JsonProperty("associated_with")
	private String associatedWith;
	
	@JsonProperty("associated_with_entity_id")
	private String associatedWithEntityId;
	
	@JsonProperty("associated_with_type")
	private String associatedWithType;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("identifier")
	private String identifier;
	
	@JsonProperty("publication")
	private String publication;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("patent_status")
	private String patentStatus;
	
	@JsonProperty("collaborators")
	private Set<String> collaborators=new HashSet<>();
	
	@JsonProperty("description")
	private String description;
	
}
