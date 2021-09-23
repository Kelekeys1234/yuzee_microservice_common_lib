package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProcedureStepEnum {
	YUZEE_REVIEW("Yuzee Review"), //TaskNameEnum.YUZEE_REVIEW_STUDENT_APPLICATION
	APPLICANT_REVIEWED_BY_INSTITUTION("Applicant reviewed by institution"), //TaskNameEnum.INSTITUTE_REVIEW_STUDENT_APPLICATION
	OFFERS_RECEIVED_BY_APPLICANT("Offers received by applicant"), //TaskNameEnum.MAKE_AN_OFFER
	LETTER_OF_OFFER_APPROVED_BY_APPLICANT("Letter of offer approved by applicant"), //TaskNameEnum.WAIT_FOR_STUDENT_ACCEPT_OFFER_LETTER
	COMPLETED_ENVIRONMENT("Completed environment"), //TaskNameEnum.COMPLETED_ENVIRONMENT
	INFO_SESSION("Info session"), //TaskNameEnum.INFO_SESSION
	PAYMENT("Payment"), //TaskNameEnum.PAYMENT
	PRE_TRAINING_REVIEW("Pre training review"), //TaskNameEnum.SCHEDULE_PRE_TRAINING_REVIEW
	OTHER("Other"), //TaskNameEnum.OTHER`
	JOB_APPLICATION("Job application");
	
	@Getter private String displayName;
	
	public String getName() {
		return this.name();
	}
}