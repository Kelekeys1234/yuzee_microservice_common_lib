package com.yuzee.common.lib.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyWorkWithUsElasticDto {
	@JsonProperty("id")
	private String id;

	@JsonProperty("work_with_us")
	private String workWithUs;

	@JsonProperty("description")
	private String description;
}
