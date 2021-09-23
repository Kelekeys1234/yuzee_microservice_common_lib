package com.yuzee.common.lib.dto.connection;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkDto {

	@Field(type = FieldType.Keyword, name = "following_id")
	@JsonProperty("following_id")
	private String followingId;
	
	@Field("following_type")
	@JsonProperty("following_type")
	private String followingType;
}
