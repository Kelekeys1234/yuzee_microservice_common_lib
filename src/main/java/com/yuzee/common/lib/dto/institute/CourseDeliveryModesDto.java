package com.yuzee.common.lib.dto.institute;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseDeliveryModesDto {

	@JsonProperty("delivery_mode_id")
	private String id;

	@JsonProperty("delivery_type")
	@NotEmpty(message = "delivery_type should not be blank")
	private String deliveryType;

	@JsonProperty("duration")
	private Double duration;

	@JsonProperty("duration_time")
	private String durationTime;

	@JsonProperty("study_mode")
	private String studyMode;

	@JsonProperty("course_id")
	private String courseId;
	
	@Valid
	@JsonProperty("fundings")
	@NotNull
	private ValidList<CourseDeliveryModeFundingDto> fundings;
	
	@Valid
	@JsonProperty("fees")
	@NotNull
	private ValidList<CourseFeesDto> fees;
}
