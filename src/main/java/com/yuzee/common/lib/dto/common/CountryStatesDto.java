package com.yuzee.common.lib.dto.common;

import java.util.List;

import lombok.Data;

@Data
public class CountryStatesDto {
	private String name;

	private List<StatesCityDto> cities;
}
