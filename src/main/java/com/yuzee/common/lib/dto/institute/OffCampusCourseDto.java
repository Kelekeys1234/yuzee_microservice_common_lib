package com.yuzee.common.lib.dto.institute;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
public class OffCampusCourseDto {

	@JsonProperty("off_campus_course_id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("latitude")
	private Double latitude;

	@JsonProperty("longitude")
	private Double longitude;

	@JsonProperty("admin_fee")
	private Double adminFee;

	@JsonProperty("material_fee")
	private Double materialFee;

	@JsonProperty("address")
	private String address;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("state_name")
	private String stateName;
	
	@JsonProperty("postal_code")
	private String postalCode;
	
	@JsonProperty("start_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@JsonProperty("end_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@JsonProperty("location_help_required")
	private boolean locationHelpRequired;
	
	@JsonProperty("skip_location")
	private boolean skipLocation;
	
	@JsonProperty("reference_course_id")
	private String reference_course_id;
	
	@JsonProperty(value = "reference_course_name", access = Access.READ_ONLY)
	private String reference_course_name;

}
