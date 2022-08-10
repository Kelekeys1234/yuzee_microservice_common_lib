package com.yuzee.common.lib.dto.institute;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDeliveryModesDto {

	@JsonProperty("delivery_mode_id")
	private String id;

	@JsonProperty("delivery_type")
	@NotEmpty(message = "delivery_type should not be blank")
	private String deliveryType;

	@JsonProperty("duration")
	@NotNull(message = "duration should not be empty")
	private Double duration;

	@JsonProperty("duration_time")
	@NotEmpty(message = "duration_time should not be blank")
	private String durationTime;

	@JsonProperty("study_mode")
	@NotEmpty(message = "study_mode should not be blank")
	private String studyMode;

	@JsonProperty("course_id")
	private String courseId;
	
	@JsonProperty("accessibility")
	@NotEmpty(message = "accessibility should not be blank")
	private String accessibility;
	
	@JsonProperty("is_government_eligible")
	@NotNull(message = "is_government_eligible should not be blank")
	private Boolean isGovernmentEligible;
	
	@Valid
	@JsonProperty("fundings")
	@NotNull
	private ValidList<CourseDeliveryModeFundingDto> fundings;
	
	@Valid
	@JsonProperty("fees")
	@NotNull
	private ValidList<CourseFeesDto> fees;
}
