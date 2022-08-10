package com.yuzee.common.lib.dto.scholarship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.SyncDTO;
import com.yuzee.common.lib.dto.review.ReviewStarDto;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.yuzee.common.lib.enumeration.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScholarshipSyncDto implements SyncDTO{

	@JsonProperty("scholarship_id")
	private String id;

	@JsonProperty("privacy_level")
	private String privacyLevel;

	@JsonProperty("entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	private String entityType;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonProperty("scholarship_validity")
	private String scholarshipValidity;

	@JsonProperty("scholarship_coverage")
	private String scholarshipCoverage;

	@JsonProperty("scholarship_award")
	private String scholarshipAward;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("scholarship_amount")
	private Double scholarshipAmount;

	@JsonProperty("other_coverage")
	private String otherCoverage;

	@JsonProperty("gender")
	private Gender gender;

	@JsonProperty("application_dead_line")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date applicationDeadLine;

	@JsonProperty("general_requirements")
	private String generalRequirements;

	@JsonProperty("eligible_nationality")
	private Set<String> eligbleNationality;

	@JsonProperty("how_to_apply")
	private Set<String> howToApply;

	@JsonProperty("benefits")
	private String benefits;

	@JsonProperty("conditions")
	private String conditions;

	@JsonProperty("successful_candidate_requirment")
	private String successfulCandidateRequirment;

	@JsonProperty("eligible_country")
	private Set<String> eligibleCountry;

	@JsonProperty("eligible_level")
	private Set<String> eligibleLevel;

	@JsonProperty("eligible_entity")
	private List<ScholarshipEligibleEntityDto> listOfScholarshipEligibleEntity = new ArrayList<>();

	@JsonProperty("reuquired_languages")
	private Set<String> requiredLanguages;

	@JsonProperty("scholarship_application_deadline")
	private List<ScholarshipApplicationDeadlineDto> listOfScholarshipApplicationDeadline = new ArrayList<>();

	@JsonProperty("storages")
	List<StorageDto> storages;
	
	@JsonProperty("review_count")
	private ReviewStarDto reviewCount;
	
	@Override
	public String getIdentifier() {
		return this.getId();
	}
}
