package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyWorkWithUs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095201452388870978L;
	
	@JsonProperty("id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("work_with_us")
	@Field(name = "work_with_us")
	private String workWithUs;
	
	@JsonProperty("description")
	@Field(name = "description")
	private String description;
	}
