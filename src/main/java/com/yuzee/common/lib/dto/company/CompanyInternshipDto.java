package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInternshipDto {
	
	@JsonProperty("company_internship_id")
	private String companyInternshipId;
	
	@JsonProperty("title")
	@NotBlank(message = "title should not be null/blank")
	private String title;
	
	@JsonProperty("description")
	@NotBlank(message = "description should not be null/blank")
	private String description;

	@JsonProperty("education_need")
	private String educationNeed;
	
	@JsonProperty("internship_members")
	private Set<String> ìnternshipMembers = new HashSet<>();
	
	@JsonProperty("internship_skills")
	private Set<String> ìnternshipSkills = new HashSet<>();
	
	@JsonProperty("created_date")
	private Date createdDate;
	
	@JsonProperty("user_info")
	private List<UserInitialInfoDto> userInitialInfoDto = new ArrayList<>();
	
	@JsonProperty("storage")
	private List<StorageDto> listOfStorageDto = new ArrayList<>();
	
	@JsonProperty("is_admin")
	private Boolean isAdmin;

	public CompanyInternshipDto(String companyInternshipId,
			@NotBlank(message = "title should not be null/blank") String title,
			@NotBlank(message = "description should not be null/blank") String description, String educationNeed,
			Set<String> ìnternshipMembers, Set<String> ìnternshipSkills, Date createdDate, Boolean isAdmin) {
		super();
		this.companyInternshipId = companyInternshipId;
		this.title = title;
		this.description = description;
		this.educationNeed = educationNeed;
		this.ìnternshipMembers = ìnternshipMembers;
		this.ìnternshipSkills = ìnternshipSkills;
		this.createdDate = createdDate;
		this.isAdmin = isAdmin;
	}
}