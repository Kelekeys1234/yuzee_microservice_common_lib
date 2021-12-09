package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.Data;

@Data
public class ProcedureAccessibleByDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{procudure.accessible_by.user_id.is_required}") 
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("user_initial_info")
	private UserInitialInfoDto userIntitalInfo;
}
