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
@TypeAlias("level")
public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3642689619373174784L;

	@Id
	@JsonProperty("level_id")
	@Field(name = "id")
	private String id;

	@Field(name = "name")
	private String name;

	@Field(name = "code")
	private String code;

	@Field(name = "description")
	private String description;
}
