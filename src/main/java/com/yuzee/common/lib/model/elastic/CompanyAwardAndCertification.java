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
public class CompanyAwardAndCertification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2942962945907036805L;

	@JsonProperty("award_certification_id")
	@Field(name = "id")
	private String id;

	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;

	@JsonProperty("title")
	@Field(name = "title")
	private String title;

	@JsonProperty("description")
	@Field(name = "description")
	private String description;
}