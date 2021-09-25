package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyWorkingHours implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5979724600985931922L;

	@JsonProperty("working_hour_id")
	@Field(name = "id")
	private String id;

	@JsonProperty("day_of_week")
	@Field(name = "week_day")
	private String weekDay;

	@JsonProperty("open_at")
	@Field(name = "opening_at", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "hh:mm a")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="hh:mm a")
	private Date openingAt;
	
	@JsonProperty("close_at")
	@Field(name = "closing_at", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "hh:mm a")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="hh:mm a")
	private Date achievedDate;

	@JsonProperty("is_off_day")
	@Field(name = "is_off_day")
	private Boolean isOffDay = false;
}
