package com.yuzee.common.lib.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EndosermentExistsDto {

	@JsonProperty("endorsement_exists")
	private boolean endorsementExists;
}
