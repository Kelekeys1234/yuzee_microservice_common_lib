package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InstituteType {
	PRE_SCHOOL("Pre-school", "Early education for children", ""),
	PRIMARY_SCHOOL("Primary school", "Elementary education for students", ""),
	SECONDARY_SCHOOL("Secondary school", "Middle school education for students", ""),
	SMALL_MEDIUM_PRIVATE_SCHOOL("Small to medium private school", "Private school education", ""),
	UNIVERSITY_COLLEGE("University/College", "Tertiary education for students", "");

	@Getter
	private String displayName;

	@Getter
	private String description;

	@Getter
	private String icon;
	
	public String getName() {
		return this.name();
	}
}
