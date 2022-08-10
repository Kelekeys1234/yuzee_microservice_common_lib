package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DurationTypeEnum {
	HOUR("Hour(s)"), WEEK("Week(s)"), MONTH("Month(s)");

	@Getter
	private String displayName;

	public String getName() {
		return this.name();
	}
}
