package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GradeType {
	SG("Single Grade", true, false),
	MSG("Multiple Subject Grade", false, true),
	SGMSG("Single Grade+Multiple Subject Grade", true, false);

	@Getter
	private String displayName;

	@Getter
	private boolean displayEducationSystemName;

	@Getter
	private boolean automaticGradeCalculator;

	public String getName() {
		return this.name();
	}
}
