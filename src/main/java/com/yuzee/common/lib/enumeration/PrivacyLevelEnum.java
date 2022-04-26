package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PrivacyLevelEnum {
	
	PUBLIC("PUBLIC","Public","Anyone can view it"),
	PRIVATE("PRIVATE","Private (Only me)","Only you can view it"),
	FOLLOWERS_ONLY("FOLLOWERS_ONLY","Followers Only","Only your followers can view it"),
	INSTITUTIONS_ONLY("INSTITUTIONS_ONLY","Institutions Only","Only institutions can view it"),
	COMPANIES_ONLY("COMPANIES_ONLY","Companies Only","Only companies can view it"),
	INSTITUTIONS_AND_COMPANIES("INSTITUTIONS_AND_COMPANIES","Institutions and Companies","Both can view it");
	
	
	@Getter 
	private String displayValue;
	
	@Getter 
	private String displayName;
	
	@Getter 
	private String description;
}
