package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CoursePreresquisite implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Field("id")
	private String id;

	@JsonProperty("prerequisite")
	@Field("prerequisite")
	private String prerequisite;

}
