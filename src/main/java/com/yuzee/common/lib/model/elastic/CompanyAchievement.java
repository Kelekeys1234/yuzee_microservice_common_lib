package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAchievement implements Serializable {
	
	private static final long serialVersionUID = 992056623806787005L;

	@JsonProperty("id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;
	
	@JsonProperty("title")
	@Field(name = "title")
	private String title;
	
	@JsonProperty("description")
	@Field(name = "description")
	private String description;
	
	@JsonProperty("achieved_date")
	@Field(name = "achieved_date", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date achievedDate;
	
	@JsonProperty("achievement_taged_user")
	@Field(name = "achievement_taged_user",type= FieldType.Nested)
	private List<AchievementTagedUser> listOfAchievementTagedUser = new ArrayList<>();
}
