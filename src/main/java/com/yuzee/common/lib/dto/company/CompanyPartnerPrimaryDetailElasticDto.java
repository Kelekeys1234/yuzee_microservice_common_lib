package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPartnerPrimaryDetailElasticDto {

	@JsonProperty("id")
	private String id;

	@JsonProperty("privacy_level")
	private String privacyLevel;

	@JsonProperty("company_partner")
	private List<CompanyPartnerElasticDto> listOfCompanyPartner = new ArrayList<>();

}
