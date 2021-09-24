package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;

import com.yuzee.common.lib.enumeration.ApplicantStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JobApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7760827627355223405L;
	
	@Field(name = "id")
	private String id;
	
	@Field(name = "user_id")
	private String userId;
	
	@Field(name = "applicant_status")
	private String applicantStatus = ApplicantStatus.DRAFT.name();
	
	@Field(name = "applicant_profile_setting")
	private ApplicantProfileSetting applicantProfileSetting;

	@Field(name = "jobApplicant")
	private List<JobApplicantAudit> listOfJobApplicantAudits = new ArrayList<>();
}