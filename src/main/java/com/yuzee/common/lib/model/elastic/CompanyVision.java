package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyVision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5742446996036664927L;
	
	@Field(name = "id")
	private String id;
	
	@Field(name = "privacy_level")
	private String privacyLevel;
	
	@Field(name = "vision")
	private String vision;
	
	@Field(name = "company_culture")
	private CompanyCulture companyCulture;
}
