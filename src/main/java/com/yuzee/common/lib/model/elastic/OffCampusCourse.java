package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OffCampusCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("off_campus_course_id")
	@Field("off_campus_course_id")
	private String id;

	@JsonProperty("latitude")
	@Field("latitude")
	private Double latitude;

	@JsonProperty("longitude")
	@Field("longitude")
	private Double longitude;

	@JsonProperty("admin_fee")
	@Field("admin_fee")
	private Double adminFee;

	@JsonProperty("material_fee")
	@Field("material_fee")
	private Double materialFee;

	@JsonProperty("address")
	@Field("address")
	private String address;

	@JsonProperty("country_name")
	@Field("country_name")
	private String countryName;

	@JsonProperty("city_name")
	@Field("city_name")
	private String cityName;

	@JsonProperty("state_name")
	@Field("state_name")
	private String stateName;

	@JsonProperty("postal_code")
	@Field("postal_code")
	private String postalCode;

	@JsonProperty("start_date")
	@Field("start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@JsonProperty("end_date")
	@Field("end_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
}
