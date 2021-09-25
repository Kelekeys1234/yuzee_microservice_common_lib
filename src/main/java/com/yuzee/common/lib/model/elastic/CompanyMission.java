package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyMission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2570260298142655815L;

	@Field(name = "id")
	private String id;

	@Field(name = "privacy_level")
	private String privacyLevel;

	@Field(name = "mission")
	private String mission;

}
