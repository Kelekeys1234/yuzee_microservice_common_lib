package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultType {

	FINAL_RESULT("Final result"), 
	MID_YEAR_RESULT("Mid year results"), 
	TRIAL_RESULTS("Trial results"), 
	UNGRADED_PASS("Ungraded pass"), 
	UNGRADED_FAIL("Ungraded fail"), 
	EXTERNAL_INSTITUTION_PASS("External Institution pass"), 
	EXTERNAL_INSTITUTION_FAIL("External Institution fail"), 
	ASSESMENT_PENDING("Assessment pending"), 
	RESULT_NOT_FINALISED("Result not finalised"), 
	RESULT_WITHHELD("Result withheld"), 
	WITHDRAWN_EARLY("Withdrawn early"), 
	WITHDRAWN("Withdrawn"); 
	 
	
	@Getter
	private String displayName;

	public String getName() {
		return this.name();
	}

}
