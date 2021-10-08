package com.yuzee.common.lib.dto.job;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.ApplicantStatus;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class JobApplicationDto {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("applicant_status")
	private String applicantStatus = ApplicantStatus.DRAFT.name();
	
	@JsonProperty("applicant_profile_setting")
	private JobApplicationProfileSettingDto applicantProfileSetting;

	@JsonProperty("jobApplicant")
	private List<JobApplicantAudit> listOfJobApplicantAudits = new ArrayList<>();
}