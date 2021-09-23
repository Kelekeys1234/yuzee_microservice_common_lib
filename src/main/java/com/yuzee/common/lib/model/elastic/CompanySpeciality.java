package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanySpeciality implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7084887423536507555L;
	
	@JsonProperty("company_speciality_id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("speciality_id")
	@Field("speciality_id")
	private String specialityId;
	
	@JsonProperty("speciality_name")
	@Field("speciality_name")
	private String specialityName;
	
}
