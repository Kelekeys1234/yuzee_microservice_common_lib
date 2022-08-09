package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SortingOnEnum {
	
	CREATED_ON("createdOn"),
	
	UPDATED_ON("updatedOn");

	@Getter private String displayName;

	public String getName() {
		return this.name();
	} 
}
