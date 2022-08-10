package com.yuzee.common.lib.dto.scholarship;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ScholarshipApplicationDeadlineDto {

	@JsonProperty("scholarship_application_deadline_id")
	private String id;

	@JsonProperty("student_type")
	private String studentType;

	@JsonProperty("scholarship_intakes")
	private List<ScholarshipApplicationDeadlineIntakeDto> scholarshipIntakes = new ArrayList<>();

}