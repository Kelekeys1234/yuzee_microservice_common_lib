package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EntitySubTypeEnum {
	
	ATTACHEMENT(false),
	ATTACHMENT_SINGLE_ENTITY(true),
	ABOUT_US(false),
	ACADEMIC_QUALIFICATION(false), 
	ACCREDIATED(true), 
	ACHIEVEMENT(false), 
	AVTAR_FEMALE(false), 
	AVTAR_MALE(false), 
	BANK_STATEMENT(false),
	BIRTH_CERTIFICATE(false),
	COVER_PHOTO(true),
	DOCUMENTS(false),
	DOCUMENT_SINGLE_ENTITY(true),
	DOWNLOADS(false), 
	ENGLISH_QUALIFICATION(false), 
	EDUCATION(false), 
	LANGUAGE_QUALIFICATION(false), 
	ENGLISH_TEST(false), 
	FUTURE_ME(false),
	ABOUT_ME(true),
	IMAGES(false),
	JOIN_REQUEST(false),
	LICENSE(false), 
	LOGO(true),
	MEDIA(false),
	PASSPORT(false), 
	PERSONAL_STATEMENT(false), 
	PORTFOLIO(false), 
	PROFILE(true), 
	REFERENCE_LETTER(false), 
	RESUME(true),
	SUPPLEMENTARY_FORM(false), 
	WORK_EXPERIENCE(false),
	ESSAY(false),
	IELTS_OR_TOFEL_CERTIFICATES(false),
	SAT_SCORES(false),
	FINANCIAL_PROOF(false),
	STATEMENT_OF_PURPOSE(false),
	WORK_PORTFOLIO(false),
	ACCOMPLISHMENT_MEDIA(false),
	PROFILE_VIDEO(true),
	SCHOLARSHIP(false),
	COMPANY_ACHIEVEMENT_CERTIFICATES(false),
	COMPANY_STAFF_INTERVIEW_VIDEO(false),
	COMPANY_CAREER_ADVICE_MEDIA(false),
	COMPANY_CAREER_ADVICE_ATTACHEMENT(false),
	COMPANY_INTERNSHIP_MEDIA(false),
	COMPANY_INTERNSHIP_ATTACHMENT(false),
	COMPANY_AWARD_CERTIFICATION_LOGO(false),
	COMPANY_INTERNSHIP_COVER_PHOTO(false),
    VIDEO(false), 
    COMPANY_STAFF_INTERVIEW(false), 
    COMPANY_CAREER_ADVICE(false),
    SCHOLARSHIP_PITCH(false),
    VIDEO_PITCH(false),
    PRE_TRAINING_REVIEW_ATTACHMENT(true),
    OTHER_REQUIREMENT_ATTACHMENT(true),
	SCHOLARSHIP_LOGO(false),
	SCHOLARSHIP_COVER_PHOTO(false),
	SCHOLARSHIP_ATTACHMENT(false),
	JOB_MEDIA(false),
	JOB_SAMPLE_MEDIA(false),
	CHILDREN_CHECK_CERTIFICATE(true),
	POLICE_CHECK_CERTIFICATE(true),
	FIRST_AID_CHECK_CERTIFICATE(true);
	
	@Getter private boolean singleEntity;
	
	public String getName() {
		return this.name();
	}

}
