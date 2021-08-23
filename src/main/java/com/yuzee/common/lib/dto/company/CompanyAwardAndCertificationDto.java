package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAwardAndCertificationDto {

	@JsonProperty("award_certification_id")
	private String awardCertificationId;
	
	@NotBlank(message = "privacy_level should not be null/blank")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("title")
	@NotBlank(message = "title can not be null/empty")
	private String title;
	
	@JsonProperty("description")
	@NotBlank(message = "description can not be null/empty")
	private String description;
	
	@JsonProperty("storage")
	private List<StorageDto> listOfStorageDto = new ArrayList<>();
	
	@JsonProperty("is_admin")
	private Boolean isAdmin;

	public CompanyAwardAndCertificationDto(String awardCertificationId,
			@NotBlank(message = "title can not be null/empty") String title,
			@NotBlank(message = "description can not be null/empty") String description, String privacyLevel, Boolean isAdmin) {
		super();
		this.awardCertificationId = awardCertificationId;
		this.title = title;
		this.description = description;
		this.privacyLevel = privacyLevel;
		this.isAdmin = isAdmin;
	}
}