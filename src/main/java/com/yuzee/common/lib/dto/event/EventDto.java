package com.yuzee.common.lib.dto.event;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDto {
	
	@JsonProperty("event_id")
	private String eventId;

	@NotNull(message = "is_public should not be null")
	@JsonProperty("is_public")
	private Boolean isPublic;
	
	@NotNull(message = "parking should not be null")
	@JsonProperty("parking")
	private String parkingAvailabilityEnum;
	
	@JsonProperty("event_name")
	@NotBlank(message = "event_name should not be blank or empty")
	private String eventName;
	
	@JsonProperty("event_category")
	@NotBlank(message = "event_category should not be blank or empty")
	private String eventCategory;
	
	@JsonProperty("event_description")
	@NotBlank(message = "event_description should not be blank or empty")
	private String eventDescription;
	
	@JsonProperty("city")
	@NotBlank(message = "city should not be blank or empty")
	private String city;
	
	@JsonProperty("state")
	@NotBlank(message = "state should not be blank or empty")
	private String state;

	@JsonProperty("country")
	@NotBlank(message = "country should not be blank or empty")
	private String country;
	
	@JsonProperty("address")
	@NotBlank(message = "address should not be blank or empty")
	private String address;
	
	@JsonProperty( "postal_code")
	@NotBlank(message = "postal_code should not be blank or empty")
	private String postalCode;
	
	@JsonProperty("latitude")
	@NotNull(message = "longitude should not be null")
	private Double latitude;
	
	@JsonProperty("longitude")
	@NotNull(message = "longitude should not be null")
	private Double longitude;
	
	@JsonProperty("event_start_date")
	@NotNull(message = "event_start_date should not be null")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private Date eventStartDate;
	
	@JsonProperty( "event_end_date")
	@NotNull(message = "event_end_date should not be null")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private Date eventEndDate;
	
	@JsonProperty("event_start_time")
	@NotNull(message = "event_start_time should not be null")
	@JsonFormat(pattern = "HH:MM", shape = JsonFormat.Shape.STRING)
	private Date eventStartTime;
	
	@JsonProperty("event_end_time")
	@NotNull(message = "event_end_time should not be null")
	@JsonFormat(pattern = "HH:MM" ,shape = JsonFormat.Shape.STRING)
	private Date eventEndTime;
	
	@JsonProperty("contact_number")
	@NotBlank(message = "contact_number should not be blank or empty")
	private String contactNumber;
	
	@Email
	@JsonProperty("email")
	@NotBlank(message = "email should not be blank or empty")
	private String email;
	
	@JsonProperty("website_url")
	@NotBlank(message = "website_url should not be blank or empty")
	private String websiteUrl;
	
	@JsonProperty( "detail_info")
	@NotBlank(message = "detail_info should not be blank or empty")
	private String detailInfo;
	
	@JsonProperty("fees")
	@NotBlank(message = "fees should not be blank or empty")
	private String fees;
	
	@JsonProperty("image_url")
	private String imageUrl;

	@NotBlank(message = "event_mode should not be blank or empty")
	@JsonProperty("event_mode")
	private String eventMode;
	
	@JsonProperty("number_of_like")
	private Long numberOfLikes;
	
	@JsonProperty("number_of_comment")
	private Long numberOfComments;
	
	@JsonProperty("number_of_user_joined")
	private Long numberOfUserJoined;
	
	@JsonProperty("is_owner")
	private Boolean isOwner = false;
	
	@JsonProperty("has_liked")
	private Boolean hasLiked = false;
	
	@JsonProperty("has_joined")
	private Boolean hasJoined = false;

	@JsonProperty("platform_name")
	private String platformName;

	@JsonProperty("platform_link")
	private String platformLink;
	
	@JsonProperty("is_ticket_available")
	private Boolean ticketAvailable = false;
	
	public EventDto(String eventId, Boolean isPublic,
			@NotBlank(message = "event_name should not be blank or empty") String eventName,
			@NotBlank(message = "event_description should not be blank or empty") String eventDescription,
			@NotBlank(message = "city should not be blank or empty") String city,
			@NotBlank(message = "state should not be blank or empty") String state,
			@NotBlank(message = "country should not be blank or empty") String country,
			@NotBlank(message = "address should not be blank or empty") String address,
			@NotBlank(message = "postal_code should not be blank or empty") String postalCode,
			@NotNull(message = "longitude should not be null") Double latitude,
			@NotNull(message = "longitude should not be null") Double longitude,
			@NotNull(message = "event_start_date should not be null") Date eventStartDate,
			@NotNull(message = "event_end_date should not be null") Date eventEndDate,
			@NotNull(message = "event_start_time should not be null") Date eventStartTime,
			@NotNull(message = "event_end_time should not be null") Date eventEndTime,
			@NotBlank(message = "contact_number should not be blank or empty") String contactNumber,
			@Email @NotBlank(message = "email should not be blank or empty") String email,
			@NotBlank(message = "website_url should not be blank or empty") String websiteUrl,
			@NotBlank(message = "detail_info should not be blank or empty") String detailInfo,
			@NotBlank(message = "fees should not be blank or empty") String fees,
			@NotBlank(message = "event_category should not be blank or empty") String eventCategory, 
			String eventMode, String parkingAvailabilityEnum,String platformName, String platformLink, Boolean ticketAvailable) {
		super();
		this.eventId = eventId;
		this.isPublic = isPublic;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.city = city;
		this.state = state;
		this.country = country;
		this.address = address;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
		this.contactNumber = contactNumber;
		this.email = email;
		this.websiteUrl = websiteUrl;
		this.detailInfo = detailInfo;
		this.fees = fees;
		this.eventCategory= eventCategory;
		this.eventMode = eventMode;
		this.parkingAvailabilityEnum = parkingAvailabilityEnum;
		this.platformName = platformName;
		this.platformLink = platformLink;
		this.ticketAvailable = ticketAvailable;
	}
}