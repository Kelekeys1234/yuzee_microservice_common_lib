package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LanguageProficiencyTypeEnum {
	ELEMENTARY("Elementary Proficiency"),
	LIMITED_WORKING("Limited working Proficiency"),
	FULL_PROFESSIONAL("Full professional Proficiency"),
	PROFESSIONAL_WORKING("Professional working Proficiency"),
	NATIVE_OR_BILINGUAL("Native or bilingual Proficiency");
	
	@Getter private String displayName;
	
	public String getName() {
		return this.name();
	}
}
