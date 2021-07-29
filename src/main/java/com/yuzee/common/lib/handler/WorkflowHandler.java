package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.user.UserEducationDto;
import com.yuzee.common.lib.dto.workflow.ProcedureStepDto;
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
	
	private static final String CREATE_DEPLOYMENT_URL = IConstant.WORKFLOW_CONNECTION_URL + "/deployment";
	
	private static final String RUN_DEPLOYMENT_URL = IConstant.WORKFLOW_CONNECTION_URL + "/deployment/{id}/run";
	
	

	
	public String createDeployment(List<ProcedureStepDto> procedureStepDtoList) throws InvokeException {
		ResponseEntity<GenericWrapperDto<String>> createDeployement = null;

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    try {
	    	HttpEntity<List<ProcedureStepDto>> entity = new HttpEntity<>(procedureStepDtoList, headers);
	    	StringBuilder path = new StringBuilder();
			path.append(CREATE_DEPLOYMENT_URL);
			createDeployement = restTemplate.exchange(path.toString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {});
			if (createDeployement.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + createDeployement.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return createDeployement.getBody().getData();
	}
	
	public String runDeployment(String id, String isReviewed) throws InvokeException {
		ResponseEntity<GenericWrapperDto<String>> runDeployement = null;

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    Map<String, String> params = new HashMap<>();
	    params.put("id", id);
	    params.put("isReviewed", isReviewed);
	    try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
	    	StringBuilder path = new StringBuilder();
	    	path.append(RUN_DEPLOYMENT_URL);
	    	runDeployement = restTemplate.exchange(path.toString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {},params);
			if (runDeployement.getStatusCode().value() != 200) {
				throw new InvokeException (ERROR_FROM_WORKFLOW_SERVICE_MEG + runDeployement.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			log.error(WORKFLOW_INVOKE_EXCEPTION_MSG, e);
			throw e;
		}
		catch (Exception e) {
			throw new InvokeException(WORKFLOW_INVOKE_EXCEPTION_MSG,e);
		}
		return runDeployement.getBody().getData();
	}
	
}
