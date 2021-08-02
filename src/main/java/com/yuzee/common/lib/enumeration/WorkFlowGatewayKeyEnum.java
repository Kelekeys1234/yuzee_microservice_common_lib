package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum WorkFlowGatewayKeyEnum {
	
	YUZEE_APPLICATION_REVIEW("yuzeeApplicationReviewStatus"),
	
	INSTITUTE_APPLICATION_REVIEW("instituteApplicationReviewStatus"),
	
	STUDENT_OFFER("studentOffer"),
	
	IS_CONTINUE("isContinue"),
	
	IS_STUDENT_ATTENDED("studentAttendedStatus");
	
	@Getter private String gatewayKey;

}
