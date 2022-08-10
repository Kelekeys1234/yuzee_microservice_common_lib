package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseFunding implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("course_funding_id")
	@Field("course_funding_id")
	private String id;

	@JsonProperty(value = "funding_name_id")
	@Field(value = "funding_name_id")
	@NotEmpty(message = "funding_name_id must not be null")
	private String fundingNameId;
}
