package com.yuzee.common.lib.dto.institute;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InstituteDto {
	
	@JsonProperty("institute_id")
	private String id;
	
	@JsonProperty("name")
	@NotBlank(message = "name should not be blank")
	private String name;
	
	@JsonProperty("city_name")
	@NotBlank(message = "city_name should not be blank")
	private String cityName;
	
	@JsonProperty("country_name")
	@NotBlank(message = "country_name should not be blank")
	private String countryName;
	
	@JsonProperty("world_ranking")
	private Integer worldRanking;
	
	@JsonProperty("logo_url")
	private String logoUrl;
	
	@JsonProperty("website")
	private String website;
	
	@JsonProperty("campus_name")
	private String campusName;
	
	@JsonProperty("latitude")
	private Double latitude;
	
	@JsonProperty("longitude")
	private Double longitude;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("whatsapp_number")
	private String whatsNo;
	
	@JsonProperty("domestic_ranking")
	private Integer domesticRanking;
	
	@JsonProperty("about_us")
	private String aboutUs;
	
	@JsonProperty("tag_line")
	private String tagLine;

	@JsonProperty("stars")
	private double stars;
	
	@JsonProperty("state_name")
	private String stateName;
	
	@JsonProperty("total_courses")
	private Long totalCourses;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("created_on")
	private Date createdOn;
}