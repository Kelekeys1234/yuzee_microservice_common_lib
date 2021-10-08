package com.yuzee.common.lib.dto.connection;
import java.time.LocalDateTime;

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
public class NetworkDto {

	@Field( name = "following_id")
	@JsonProperty("following_id")
	private String followingId;
	
	@Field("following_type")
	@JsonProperty("following_type")
	private String followingType;
	
	@Field(name = "created_on", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd'T'HH:mm:ss")
	@JsonProperty("created_on")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdOn;
}