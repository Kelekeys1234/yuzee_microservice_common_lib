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
public class ScholarshipApplicationDeadlineIntake implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("intake_id")
	@Field(name = "id")
	private String id;

	@JsonProperty("intake_key")
	@Field("intake_key")
	private String intakeKey;

	@JsonProperty("intake_value")
	@Field("intake_value")
	private String intakeValue;
}