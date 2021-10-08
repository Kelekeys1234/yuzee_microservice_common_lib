package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class JobWorkingHours implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5352409993336648319L;

	@Field(name = "id")
	private String id;
	
	@Field(name = "day_of_week")
	private String dayOfWeek;
	
	@Field(name = "open_at", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "hh:mm a")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="hh:mm a")
	private Date openingAt;
	
	@Field(name = "close_at", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "hh:mm a")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="hh:mm a")
	private Date closingAt;
	
}
