package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseContactDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Field("course_contact_detail_id")
	@JsonProperty("course_contact_detail_id")
	private String id;

	@JsonProperty("contact_type")
	@Field("contact_type")
	@NotEmpty(message = "contact_type must not be empty")
	private String contactType;

	@JsonProperty("detail")
	@Field("detail")
	private String detail;
}