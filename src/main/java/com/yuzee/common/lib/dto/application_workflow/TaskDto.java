package com.yuzee.common.lib.dto.application_workflow;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.application.UserApplicationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto <T> {
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
	private T userApplication;
	
	@JsonProperty("process_instance_id")
	private String processInstanceId;
}
