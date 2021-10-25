package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GradeType {
	SG("Single Grade"),
	MSG("Multiple Subject Grade"),
	SGMSG("Single Grade+Multiple Subject Grade");

	@Getter
	private String displayName;

	public String getName() {
		return this.name();
	}
}
