package com.yuzee.common.lib.enumeration;

public enum UserApplicationStatusEnum {
	ALL,
	DRAFT, //create user application
	PENDING, // after submit application
	OFFERED, //TaskNameEnum.MAKE_AN_OFFER
	ACCEPTED, //TaskNameEnum.SCHEDULE_PRE_TRAINING_REVIEW
	PAYMENT_CONFIRMED, //TaskNameEnum.PAYMENT
	EXPIRED, //TaskNameEnum.PAYMENT
	REJECTED,// reject user application
	CANCELLED,// CANCELLED user application
	COMPLETED, //TaskNameEnum.COMPLETED_ENVIROMENT
	IN_REVIEW,
	HIRED
	
}
