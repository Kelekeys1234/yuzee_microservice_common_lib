package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CoursePayment implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_payment_id")
	@Field("course_payment_id")
	private String id;

	@JsonProperty("description")
	@Field("description")
	@NotEmpty(message = "description should not be blank")
	private String description;

	@Valid
	@JsonProperty("payment_items")
	@Field("payment_items")
	@NotEmpty(message = "payment_items must not be empty")
	private List<CoursePaymentItem> paymentItems = new ArrayList<>();
}
