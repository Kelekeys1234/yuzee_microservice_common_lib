package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ScholarshipApplicationDeadline implements Serializable {

	private static final long serialVersionUID = 1387401087541587123L;

	@JsonProperty("scholarship_application_deadline_id")
	@Field(name = "id")
	private String id;

	@JsonProperty("student_type")
	@Field(name = "student_type")
	private String studentType;

	@JsonProperty("scholarship_intakes")
	@Field(name = "scholarship_intakes")
	private List<ScholarshipApplicationDeadlineIntake> scholarshipIntakes = new ArrayList<>();

}