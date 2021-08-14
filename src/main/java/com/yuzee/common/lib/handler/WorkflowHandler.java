package com.yuzee.common.lib.handler;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.application.ProcedureStepDto;
import com.yuzee.common.lib.dto.application_workflow.TaskDto;
import com.yuzee.common.lib.enumeration.TaskNameEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.workflow-handler.enabled", havingValue = "true")
public class WorkflowHandler {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String ERROR_FROM_WORKFLOW_SERVICE_MEG = "Error response recieved from workflow service with error code ";
	
	private static final String WORKFLOW_INVOKE_EXCEPTION_MSG = "Error invoking workflow service {}";
	
	private static final String CREATE_DEPLOYMENT = IConstant.WORKFLOW_CONNECTION_URL + "/deployment";
	
	private static final String RUN_DEPLOYMENT = IConstant.WORKFLOW_CONNECTION_URL +"/deployment" ;
	
	private static final String URL_SEPARATOR = "/";
	
	private static final String RUN = "/run";
	
	private static final String GET_PENDING_TASK = IConstant.WORKFLOW_CONNECTION_URL + "/task";
	
	private static final String GET_COMPLETE_TASK = IConstant.WORKFLOW_CONNECTION_URL + "/history/task/completed";
	
	private static final String COMPLTED_TASK = IConstant.WORKFLOW_CONNECTION_URL +"/task/complete" ;
	
	public String createDeployment(List<ProcedureStepDto> procedureStepDtoList) throws InvokeException {
		ResponseEntity<GenericWrapperDto<String>> createDeployment = null;

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    try {
	    	HttpEntity<List<ProcedureStepDto>> entity = new HttpEntity<>(procedureStepDtoList, headers);
	    	StringBuilder path = new StringBuilder();
			path.append(CREATE_DEPLOYMENT);
			createDeployment = restTemplate.exchange(path.toString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {});
			if (createDeployment.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + createDeployment.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return createDeployment.getBody().getData();
	}
	
	public String runDeployment(String deploymentKey, Map<String, Object> userApplicationMap) {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(userApplicationMap,headers);
			StringBuilder path = new StringBuilder();
			path.append(RUN_DEPLOYMENT).append(URL_SEPARATOR).append(deploymentKey).append(RUN);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + responseEntity.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return responseEntity.getBody().getData();
	}
	
	public PaginationResponseDto<List<TaskDto>> getPendingTask(int pageNumber, int pageSize, String userApplicationId, String instituteId, TaskNameEnum taskNameEnum) {
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<TaskDto>>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(GET_PENDING_TASK)
			.append(URL_SEPARATOR).append("pageNumber")
			.append(URL_SEPARATOR).append(pageNumber)
			.append(URL_SEPARATOR).append("pageSize")
			.append(URL_SEPARATOR).append(pageSize);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			if(!ObjectUtils.isEmpty(taskNameEnum)) {			
				builder.queryParam("task_name", taskNameEnum.name());
			}
			builder.queryParam("institute_id", instituteId);
			builder.queryParam("user_application_id", userApplicationId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<TaskDto>>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + responseEntity.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return responseEntity.getBody().getData();
	}

	public List<TaskDto> getCompletedTask(String userApplicationId) {
		ResponseEntity<GenericWrapperDto<List<TaskDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(GET_COMPLETE_TASK);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("user_application_id", userApplicationId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<TaskDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + responseEntity.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return responseEntity.getBody().getData();
	}
	
	public String completeTask(String taskId, Map<String, Object> userApplicationMap) {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(userApplicationMap,headers);
			StringBuilder path = new StringBuilder();
			path.append(COMPLTED_TASK);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("task_id", taskId);

			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + responseEntity.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return responseEntity.getBody().getData();
	}
	
}
