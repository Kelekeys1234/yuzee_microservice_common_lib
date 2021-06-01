package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FavoriteEntityTypeEnum {
	ALL("All"),
	MEDIA("Post"),
	STORAGE("Videos"),
	COURSE("Courses"),
	SCHOLARSHIP("Scholarships"),
	OFF_CAMPUS("Off-campus"),
	JOBS("Jobs"),
	ARTICLE("Article"),
	APPLICATION("Application"),
	CLASS("Class");
	
	@Getter private String displayName;
	
	public String getName() {
		return this.name();
	}
}
