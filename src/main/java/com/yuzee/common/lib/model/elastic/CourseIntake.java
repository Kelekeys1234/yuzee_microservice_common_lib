package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseIntake implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_intake_id")
	@Field("course_intake_id")
	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "intake_date")
	@Field(value = "intake_date")
	@NotEmpty(message = "intake_date must not be null")
	private Date intakeDate;
}
