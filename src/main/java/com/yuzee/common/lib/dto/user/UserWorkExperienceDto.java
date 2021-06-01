package com.yuzee.common.lib.dto.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWorkExperienceDto {

	@JsonProperty("user_work_experience_id")
	private String userWorkExperienceId;
	
	@NotBlank(message = "privacy_level is required")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@NotBlank(message = "job_title is required")
	@JsonProperty("job_title")
	private String jobTitle;
	
	@NotBlank(message = "job_type is required")
	@JsonProperty("job_type")
	private String jobType;
	
	@NotBlank(message = "company_name is required")
	@JsonProperty("company_name")
	private String companyName;
	
	@NotBlank(message = "city is required")
	@JsonProperty("city")
	private String city;
	
	@NotBlank(message = "state is required")
	@JsonProperty("state")
	private String state;
	
	@NotBlank(message = "country is required")
	@JsonProperty("country")
	private String country;
	
	@NotBlank(message = "job_description is required")
	@JsonProperty("job_description")
	private String jobDescription;
	
	@JsonProperty("experience_entity_id")
	private String experienceEntityId;
	
	@JsonProperty("experience_entity_type")
	private String experienceEntityType;
	
	@NotNull(message = "start_date is required")
    @JsonFormat(pattern="yyyy-MM-dd")
	@JsonProperty("start_date")
	private Date startDate;
	
	@JsonProperty("end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@JsonProperty("collaborations")
    private Set<Object> collaborations=new HashSet<>();
	
	@JsonProperty("skills")
	List<SkillDto> skills = new ArrayList<>();
	
	@JsonProperty("certificates")
	List<StorageDto> certificates = new ArrayList<>();
	
}



