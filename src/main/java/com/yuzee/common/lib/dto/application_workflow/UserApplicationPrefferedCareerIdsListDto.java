package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationPrefferedCareerIdsListDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{user_application.career_id.is_required}") 
	@JsonProperty("career_id")
	private String careerId;
}
