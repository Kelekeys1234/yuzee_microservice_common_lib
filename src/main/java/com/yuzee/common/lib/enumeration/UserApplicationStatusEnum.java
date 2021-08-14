package com.yuzee.common.lib.enumeration;

public enum UserApplicationStatusEnum {
	SUBMISSION_INPROGRESS, //create user application
	PENDING, // after submit application
	OFFERED, //TaskNameEnum.MAKE_AN_OFFER
	ACCEPTED, //TaskNameEnum.SCHEDULE_PRE_TRAINING_REVIEW
	PAYMENT_CONFIRMED, //TaskNameEnum.PAYMENT
	COMPLETED, //TaskNameEnum.COMPLETED_ENVIROMENT
	EXPIRED, //TaskNameEnum.PAYMENT
	REJECTED // reject user application
	
}
