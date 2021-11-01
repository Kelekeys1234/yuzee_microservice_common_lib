package com.yuzee.common.lib.dto.institute;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseIntakeDto {

	@JsonProperty(value = "type")
	@NotEmpty(message = "type must not be empty")
	private String type;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "linked_course_ids must not be null")
	@JsonProperty(value = "dates")
	private List<Date> dates;
	
	@NotNull(message = "linked_course_ids must not be null")
	@JsonProperty("linked_course_ids")
	List<String> linkedCourseIds;
}
