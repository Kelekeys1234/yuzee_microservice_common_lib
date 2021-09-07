package com.yuzee.common.lib.dto.common;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CountryDto {
	private String countryId;

	private String name;

	private String description;

	private String countryCode;

	private String currencyCode;

	private Date createdOn;

	List<CountryStatesDto> states;
}
