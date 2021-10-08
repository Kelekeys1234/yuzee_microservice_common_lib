package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("event")
public class Event implements Serializable {

	private static final long serialVersionUID = -4903351881903628344L;

	@Id
	@JsonProperty("event_id")
	@Field("id")
	private String id;

	@JsonProperty("is_public")
	@Field("is_public")
	private Boolean isPublic;

	@JsonProperty("event_status")
	@Field("event_status")
	private String eventStatus;

	@JsonProperty("user_id")
	@Field("user_id")
	private String userId;

	// this is Id of institute in case of institute event
	@JsonProperty("entity_id")
	@Field("entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	@Field("entity_type")
	private String entityType;

	@JsonProperty("event_category")
	@Field("event_category")
	private String eventCategory;

	@JsonProperty("event_name")
	@Field("event_name")
	private String eventName;

	@JsonProperty("readable_id")
	@Field("readable_id")
	private String readableId;

	@JsonProperty("event_description")
	@Field("event_description")
	private String eventDescription;

	@JsonProperty("city")
	@Field("city")
	private String city;

	@JsonProperty("state")
	@Field("state")
	private String state;

	@JsonProperty("country")
	@Field("country")
	private String country;

	@JsonProperty("address")
	@Field("address")
	private String address;

	@JsonProperty("postal_code")
	@Field("postal_code")
	private String postalCode;

	@JsonProperty("latitude")
	@Field("latitude")
	private Double latitude;

	@JsonProperty("longitude")
	@Field("longitude")
	private Double longitude;

	@Field(name = "event_start_date", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("event_start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate eventStartDate;

	@Field(name = "event_end_date", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("event_end_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate eventEndDate;

	@JsonProperty("event_start_time")
	@Field(name = "event_start_time", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "hh:mm a")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
	private Date eventStartTime;

	@JsonProperty("event_end_time")
	@Field(name = "event_end_time", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "hh:mm a")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
	private Date eventEndTime;

	@JsonProperty("country_code")
	@Field("country_code")
	private String countryCode;

	@JsonProperty("contact_number")
	@Field("contact_number")
	private String contactNumber;

	@JsonProperty("email")
	@Field("email")
	private String email;

	@JsonProperty("website_url")
	@Field("website_url")
	private String websiteUrl;

	@JsonProperty("detail_info")
	@Field("detail_info")
	private String detailInfo;

	@JsonProperty("fees")
	@Field("fees")
	private String fees;

	@JsonProperty("mode")
	@Field("mode")
	private String eventMode;

	@JsonProperty("parking_avaliability_enum")
	@Field("parking_avaliability_enum")
	private String parkingAvailabilityEnum;

	@JsonProperty("user_joined_events")
	@Field(name = "user_joined_events", type = FieldType.Nested)
	private List<UserJoinEvent> userJoinedEvents;

	@JsonProperty("platform_name")
	@Field("platform_name")
	private String platformName;

	@JsonProperty("platform_link")
	@Field("platform_link")
	private String platformLink;

	@JsonProperty("is_ticket_available")
	@Field("is_ticket_available")
	private Boolean ticketAvailable;

	@JsonProperty("ticket_link")
	@Field("ticket_link")
	private String ticketLink;
}