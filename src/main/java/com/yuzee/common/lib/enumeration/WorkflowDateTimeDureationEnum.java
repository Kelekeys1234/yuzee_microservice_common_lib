
package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum WorkflowDateTimeDureationEnum {
	
	WAIT_FOR_STUDENT_ACCEPT_OFFER_FOR_REMINDER1_TIMEDURATION("waitForStudentAcceptOfferForReminder1timeduration"),
	
	WAIT_FOR_STUDENT_ACCEPT_OFFER_FOR_REMINDER2_TIMEDURATION("waitForStudentAcceptOfferForReminder2timeduration"),
	
	WAIT_FOR_STUDENT_ACCEPT_OFFER_FOR_GRACE_PERIOD_TIMEDURATION("waitForStudentAcceptOfferForGracePeriodtimeduration"),

	WAIT_FOR_GRACE_PERIOD_TO_COMPLETE_BOUNDRY_EVENT_TIMEDURATION("waitForGracePeriodToCompletetimeduration"),
	
	WAIT_FOR_SCHEDULE_PRE_TRAINING_REVIEW_TIMEDATE("waitForSchedulePreTrainingReviewtimedate");
	
	@Getter private String timeDateOrTimeDuration;

}
