package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseDeliveryMode implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_delivery_mode_id")
	@Field("course_delivery_mode_id")
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

	@JsonProperty("domestic_fee")
	@Field("domestic_fee")
	@NotNull(message = "domestic_fee should not be blank")
	private Double domesticFee;

	@JsonProperty("international_fee")
	@Field("international_fee")
	@NotNull(message = "international_fee should not be blank")
	private Double internationalFee;

	@JsonProperty("study_mode")
	@Field("study_mode")
	private String studyMode;

	@JsonProperty("usd_domestic_fee")
	@Field("usd_domestic_fee")
	private Double usdDomesticFee;

	@JsonProperty("usd_international_fee")
	@Field("usd_international_fee")
	private Double usdInternationalFee;
}
