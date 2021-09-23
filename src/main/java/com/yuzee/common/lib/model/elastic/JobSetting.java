package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

@Data
public class JobSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7637406720991749993L;
	
	@Field(name = "have_start_dates")
	private boolean haveStartDate;
	
	@Field(name = "have_application_deadline")
	private boolean haveApplicationDeadline;
	
	@Field(name = "is_salary_specified")
	private boolean isSalarySpecified;
	
	@Field(name = "have_fix_number_of_hire")
	private boolean haveFixNumberOfHire;
	
	@Field(name = "require_applicant_resume")
	private boolean requireApplicantResume;
	
	@Field(name = "require_daily_update_on_job")
	private boolean requireDailyUpdateOnJob;
	
	@Field(name = "require_intelligence_matching" )
	private boolean requireIntelligenceMatching;
	
	@Field(name = "require_AI_assist")
	private boolean requireAIAssist;
	
	@Field(name = "require_test_completion")
	private boolean requireTestCompletion;
	
	@Field(name = "require_yuzee_assistance")
	private boolean requireYuzeeAssistance;
	
	@Field(name = "consider_company_culture")
	private boolean considerCompanyCulture;
}
