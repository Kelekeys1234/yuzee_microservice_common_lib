package com.yuzee.common.lib.dto.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserDeviceInfoDto;

import lombok.Data;

@Data
public class UserDeviceInfoWrapperDto {

	@JsonProperty("message")
	public String message;

	@JsonProperty("data")
	public List<UserDeviceInfoDto> data;

	@JsonProperty("status")
	public String status;
}
