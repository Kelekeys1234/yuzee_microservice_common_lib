package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseIntake implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "type")
	@Field(value = "type")
	@NotEmpty(message = "type must not be empty")
	private String type;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "dates")
	@Field(value = "dates")
	private List<Date> dates;

}
