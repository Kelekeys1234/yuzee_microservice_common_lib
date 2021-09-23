package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseCurriculum implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_curriculum_id")
	@Field("course_curriculum_id")
	private String id;

	@JsonProperty("name")
	@Field("name")
	private String name;
}
