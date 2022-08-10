package com.yuzee.common.lib.dto.job;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JobSettingDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7637406720991749993L;
	
	@JsonProperty("have_start_dates")
	private boolean haveStartDate;
	
	@JsonProperty("have_application_deadline")
	private boolean haveApplicationDeadline;
	
	@JsonProperty("is_salary_specified")
	private boolean isSalarySpecified;
	
	@JsonProperty("have_fix_number_of_hire")
	private boolean haveFixNumberOfHire;
	
	@JsonProperty("require_applicant_resume")
	private boolean requireApplicantResume;
	
	@JsonProperty("require_daily_update_on_job")
	private boolean requireDailyUpdateOnJob;
	
	@JsonProperty("require_intelligence_matching" )
	private boolean requireIntelligenceMatching;
	
	@JsonProperty("require_AI_assist")
	private boolean requireAIAssist;
	
	@JsonProperty("require_test_completion")
	private boolean requireTestCompletion;
	
	@JsonProperty("require_yuzee_assistance")
	private boolean requireYuzeeAssistance;
	
	@JsonProperty("consider_company_culture")
	private boolean considerCompanyCulture;
}
