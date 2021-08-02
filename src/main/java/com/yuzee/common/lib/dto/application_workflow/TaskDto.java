package com.yuzee.common.lib.dto.application_workflow;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("stepName")
	private String stepName;
	
	@JsonProperty("userApplicationStatus")
	private String userApplicationStatus;
	
	@JsonProperty("taskLocalVariables")
	private Map<String, Object> taskLocalVariables;
	
	@JsonProperty("taskProcessVariables")
	private Map<String, Object> taskProcessVariables;
	
	@JsonProperty("userApplication")
	private UserApplicationDto userApplication;
}
