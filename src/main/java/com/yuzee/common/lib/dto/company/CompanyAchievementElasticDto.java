package com.yuzee.common.lib.dto.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAchievementElasticDto implements Serializable {
	
	private static final long serialVersionUID = 992056623806787005L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("achieved_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date achieved_date;
	
	@JsonProperty("achievement_taged_user")
	private List<AchievementTagedUserElasticDto> listOfAchievementTagedUser = new ArrayList<>();
}
