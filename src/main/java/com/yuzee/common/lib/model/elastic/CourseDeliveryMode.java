package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;
import com.yuzee.common.lib.dto.institute.CourseDeliveryModeFundingDto;
import com.yuzee.common.lib.dto.institute.CourseFeesDto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseDeliveryMode implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("delivery_mode_id")
	@Field("delivery_mode_id")
	private String id;

	@JsonProperty("delivery_type")
	@Field("delivery_type")
	@NotEmpty(message = "delivery_type should not be blank")
	private String deliveryType;

	@JsonProperty("duration")
	@Field("duration")
	private Double duration;

	@JsonProperty("duration_time")
	@Field("duration_time")
	private String durationTime;

	@JsonProperty("study_mode")
	@Field("study_mode")
	private String studyMode;

	@JsonProperty("course_id")
	@Field("course_id")
	private String courseId;
	
	@JsonProperty("accessibility")
	@Field("accessibility")
	private String accessibility;
	
	@JsonProperty("is_government_eligible")
	@Field("is_government_eligible")
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
