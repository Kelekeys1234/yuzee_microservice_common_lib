package com.yuzee.common.lib.enumeration;

public enum UserApplicationStatusEnum {
	SUBMISSION_INPROGRESS, //create user application
	PENDING, //TaskNameEnum.VIEW_APPLICATION
	OFFERED, //TaskNameEnum.MAKE_AN_OFFER
	ACCEPTED, //TaskNameEnum.SCHEDULE_PRE_TRAINING_REVIEW
	PAYMENT_CONFIRMED, //TaskNameEnum.PAYMENT
	COMPLETED, //COMPLETED_ENVIROMENT
	REJECTED // reject user application
}
