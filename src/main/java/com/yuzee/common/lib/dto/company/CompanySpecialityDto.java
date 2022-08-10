package com.yuzee.common.lib.dto.company;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanySpecialityDto {

	@JsonProperty("company_speciality_id")
	private String id;
	
	@JsonProperty("speciality_id")
	@NotEmpty(message = "speciality_id can not be null/empty")
	private String specialityId;
	
	@JsonProperty("speciality_name")
	@NotEmpty(message = "speciality_name can not be null/empty")
	private String specialityName;
}
