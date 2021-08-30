package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
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
@NoArgsConstructor
@AllArgsConstructor
public class CompanyStaffInterviewDto {

	@JsonProperty("company_staff_interview_id")
	private String companyStaffInterviewId;
	
	@NotBlank(message = "title should not be null / blank")
	@JsonProperty("title")
	private String title;
	
	@NotBlank(message = "discription should not be null / blank")
	@JsonProperty("discription")
	private String discription;
	
	@JsonProperty("taged_interviewee")
	private Set<String> tagedInterviewee = new HashSet<>();
	
	@JsonProperty("taged_interviewee_initial_info")
	private List<UserInitialInfoDto> tagedUserInitialInfoDto = new ArrayList<>();
	
	@JsonProperty("storage")
	private List<StorageDto> listOfStorageDto = new ArrayList<>();
	
	@JsonProperty("is_admin")
	private boolean isAdmin;

	public CompanyStaffInterviewDto(String companyStaffInterviewId,
			@NotBlank(message = "title should not be null / blank") String title,
			@NotBlank(message = "discription should not be null / blank") String discription,
			Set<String> tagedInterviewee) {
		super();
		this.companyStaffInterviewId = companyStaffInterviewId;
		this.title = title;
		this.discription = discription;
		this.tagedInterviewee = tagedInterviewee;
	}
}