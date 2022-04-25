package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProcedureStepEnum {
//	YUZEE_REVIEW("Yuzee Review",true), //TaskNameEnum.YUZEE_REVIEW_STUDENT_APPLICATION
	APPLICANT_REVIEWED_BY_INSTITUTION("Applicant reviewed by institution",false), //TaskNameEnum.INSTITUTE_REVIEW_STUDENT_APPLICATION
	OFFERS_RECEIVED_BY_APPLICANT("Offers received by applicant",false), //TaskNameEnum.MAKE_AN_OFFER
	LETTER_OF_OFFER_APPROVED_BY_APPLICANT("Letter of offer approved by applicant",false), //TaskNameEnum.WAIT_FOR_STUDENT_ACCEPT_OFFER_LETTER
	COMPLETED_ENVIRONMENT("Completed environment",false), //TaskNameEnum.COMPLETED_ENVIRONMENT
	INFO_SESSION("Info session",true), //TaskNameEnum.INFO_SESSION
	PAYMENT("Payment",true), //TaskNameEnum.PAYMENT
	PRE_TRAINING_REVIEW("Pre training review",true), //TaskNameEnum.SCHEDULE_PRE_TRAINING_REVIEW
	OTHER("Other",true), //TaskNameEnum.OTHER`
	JOB_APPLICATION("Job application",true);
	
	@Getter private String displayName;
	
	@Getter private boolean isAllowToDelete;
	
	public String getName() {
		return this.name();
	}
}