package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UserApplicationPrefferedCareerIdsDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{user_application.career_id.is_required}") 
	@JsonProperty("career_id")
	private String careerId;
	
}
