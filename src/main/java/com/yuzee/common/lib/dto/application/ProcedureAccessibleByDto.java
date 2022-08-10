package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcedureAccessibleByDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{procudure.accessible_by.user_id.is_required}") 
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty(value = "user_initial_info", access = Access.READ_ONLY)
	private UserInitialInfoDto userIntitalInfo;
}
