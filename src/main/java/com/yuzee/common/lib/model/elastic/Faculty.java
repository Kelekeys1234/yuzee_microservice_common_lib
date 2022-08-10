package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("faculty")
public class Faculty implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8766516913967886444L;

	@Id
	@Field(name = "faculty_id")
	@JsonProperty("faculty_id")
	private String id;

	@Field(name = "name")
	@JsonProperty("name")
	private String name;

	@Field(name = "description")
	@JsonProperty("description")
	private String description;

	@Field(name = "icon")
	@JsonProperty("icon")
	private String icon;


}
