package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPartnerPrimaryDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7338517746397891171L;
	
	@JsonProperty("id")
	@Field(name = "id")
	private String id;

	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;

	@JsonProperty("company_partner")
	@Field(name = "company_partner", type = FieldType.Nested)
	private List<CompanyPartner> listOfCompanyPartner = new ArrayList<>();

}
