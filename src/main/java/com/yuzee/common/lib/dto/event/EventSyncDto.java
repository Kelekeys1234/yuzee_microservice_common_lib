package com.yuzee.common.lib.dto.event;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.SyncDTO;
import com.yuzee.common.lib.dto.review.ReviewStarDto;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class EventSyncDto implements SyncDTO {

	@JsonProperty("event_id")
	private String id;

	@JsonProperty("is_public")
	private Boolean isPublic;

	@JsonProperty("event_status")
	private String eventStatus;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	private String entityType;

	@JsonProperty("event_category")
	private String eventCategory;

	@JsonProperty("event_name")
	private String eventName;

	@JsonProperty("readable_id")
	private String readableId;

	@JsonProperty("event_description")
	private String eventDescription;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;

	@JsonProperty("address")
	private String address;

	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("latitude")
	private Double latitude;

	@JsonProperty("longitude")
	private Double longitude;

	@JsonProperty("event_start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate eventStartDate;

	@JsonProperty("event_end_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate eventEndDate;

	@JsonProperty("event_start_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
	private Date eventStartTime;

	@JsonProperty("event_end_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
	private Date eventEndTime;

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("contact_number")
	private String contactNumber;

	@JsonProperty("email")
	private String email;

	@JsonProperty("website_url")
	private String websiteUrl;

	@JsonProperty("detail_info")
	private String detailInfo;

	@JsonProperty("fees")
	private String fees;

	@JsonProperty("mode")
	private String eventMode;

	@JsonProperty("parking_avaliability_enum")
	private String parkingAvailabilityEnum;

	@JsonProperty("user_joined_events")
	private List<UserJoinEventSyncDto> userJoinedEvents;

	@JsonProperty("platform_name")
	private String platformName;

	@JsonProperty("platform_link")
	private String platformLink;

	@JsonProperty("is_ticket_available")
	private Boolean ticketAvailable;

	@JsonProperty("ticket_link")
	private String ticketLink;

	@JsonProperty("storages")
	List<StorageDto> storages;
	
	@JsonProperty("review_count")
	private ReviewStarDto reviewCount;

	@Override
	public String getIdentifier() {
		return id;
	}
}
