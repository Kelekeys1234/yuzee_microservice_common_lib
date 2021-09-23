package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPreferredCourse implements Serializable {

	private static final long serialVersionUID = -5547526321763417776L;
	
	@Id
	@JsonProperty("id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("course_name")
	@Field(name = "course_name")
	private String courseName;
		
	@JsonProperty("course_id")
	@Field(name = "course_id")
	private String courseId;
}