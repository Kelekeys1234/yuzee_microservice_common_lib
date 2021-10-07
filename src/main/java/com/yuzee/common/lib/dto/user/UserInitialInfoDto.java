package com.yuzee.common.lib.dto.user;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.authorization.RoleDto;

import lombok.Data;

@Data
public class UserInitialInfoDto implements Serializable{
	
	private static final long serialVersionUID = 1623280278616563626L;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("image_path")
	private String imagePath;

	@JsonProperty("institute_name")
	private String instituteName;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("state_name")
	private String stateName;

	@JsonProperty("course_name")
	private String courseName;

	@JsonProperty("citizenship")
	private String citizenship;

	@JsonProperty("designation")
	private String designation;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("mutual_followers_count")
	private long mututalConnectionCount;
	
	@JsonProperty("already_followed")
	private boolean alreadyFollowed;
	
	@JsonProperty("already_connected")
	private boolean alreadyConnected;
	
	@JsonProperty("readable_id")
	private String readableId;
	
	@JsonProperty("roles")
	private List<RoleDto> roles;
	
	@JsonProperty( "latitude")
	private Double latitude;
	
	@JsonProperty( "longitude")
	private Double longitude;
	
	@JsonProperty("dobStr")
	private String dobStr;
	
	@JsonProperty("gender")
	private String gender;
	

}