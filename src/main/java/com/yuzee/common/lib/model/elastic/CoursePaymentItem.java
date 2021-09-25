package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CoursePaymentItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_payment_item_id")
	@Field("course_payment_item_id")
	private String id;

	@JsonProperty("name")
	@Field("name")
	@NotEmpty(message = "name should not be blank")
	private String name;

	@JsonProperty("amount")
	@Field("amount")
	@NotNull(message = "amount should not be null")
	private Double amount;
}
