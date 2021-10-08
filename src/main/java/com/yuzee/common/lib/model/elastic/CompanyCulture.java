package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCulture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2363157497224023828L;
	
	@Field(name = "id")
	private String id;
			
	@Field(name = "comapny_vision", type = FieldType.Nested)
	private CompanyVision companyVision;
	
	@Field(name = "company_mission", type = FieldType.Nested)
	private CompanyMission companyMission;
	
	@Field(name = "company_culture_people", type = FieldType.Nested)
	private List<CompanyCulturePeople> listOfCompanyCulturePeople = new ArrayList<>();
}