package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InstituteType {
	PRE_SCHOOL("Pre-school", "Early education for children", "pre-school.svg", false),
	PRIMARY_SCHOOL("Primary school", "Elementary education for students", "primary-school.svg", false),
	SECONDARY_SCHOOL("Secondary school", "Middle school education for students", "secondary-school.svg", false),
	SMALL_MEDIUM_PRIVATE_SCHOOL("Small to medium private school", "Private school education", "small-medium-private-school.svg", false),
	UNIVERSITY_COLLEGE("University/College", "Tertiary education for students", "university-college.svg", false);

	@Getter
	private String displayName;

	@Getter
	private String description;

	@Getter
	@Setter
	private String icon;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Getter @Setter private boolean initialized;
	
	public String getName() {
		return this.name();
	}
}
