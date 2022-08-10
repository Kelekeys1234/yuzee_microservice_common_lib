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
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.company.CompanyDto;
import com.yuzee.common.lib.dto.company.CompanyInitialInfoDto;
import com.yuzee.common.lib.dto.company.CultureTypeDto;
import com.yuzee.common.lib.dto.company.SubCultureTypeDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.company.enabled", havingValue = "true")
public class CompanyHandler {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String GET_COMPANY_INITIAL_INFO_BY_IDS = IConstant.COMPANY_CONNECTION_URL
			+ "/internal/company/initial-info";

	private static final String GET_COMPANY_CULTURE = IConstant.COMPANY_CONNECTION_URL
			+ "/company/{companyId}/culture/test/culture-type/question/result";

	private static final String GET_COMPANY_SUB_CULTURE = IConstant.COMPANY_CONNECTION_URL
			+ "/company/{companyId}/culture/test/sub-culture-type/question/result";

	private static final String MSG_ERROR_CODE = "Error response recieved from Company service with error code ";

	private static final String MSG_ERROR_INVOKING = "Error invoking Company service";

	public CompanyDto getCompanyInititalInfoById(String companyId) {
		ResponseEntity<GenericWrapperDto<CompanyDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMPANY_CONNECTION_URL).append("/company/").append(companyId).append("/")
					.append("initial-info");

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			HttpEntity<String> request = new HttpEntity<>(headers);

			log.info("Request URI: {}", uriBuilder.toUriString());
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, request,
					new ParameterizedTypeReference<GenericWrapperDto<CompanyDto>>() {
					});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<CompanyInitialInfoDto> getCompanyInitialInfoByIds(List<String> companyIds) {
		ResponseEntity<GenericWrapperDto<List<CompanyInitialInfoDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(GET_COMPANY_INITIAL_INFO_BY_IDS);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("company_Ids", companyIds);
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<CompanyInitialInfoDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_INVOKING
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
	
		return responseEntity.getBody().getData();
	}
	
	public CultureTypeDto getCompanyCulture(String userId, String companyId) {
		ResponseEntity<GenericWrapperDto<CultureTypeDto>> response = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put("companyId", companyId);

			HttpHeaders headers = new HttpHeaders();
			headers.add("userId", userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			response = restTemplate.exchange(GET_COMPANY_CULTURE, HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<CultureTypeDto>>() {
					}, params);
			if (response.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + response.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + response.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return response.getBody().getData();
	}
	
	public SubCultureTypeDto getCompanySubCulture(String userId, String companyId) {
		ResponseEntity<GenericWrapperDto<SubCultureTypeDto>> response = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put("companyId", companyId);

			HttpHeaders headers = new HttpHeaders();
			headers.add("userId", userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("", headers);
			response = restTemplate.exchange(GET_COMPANY_SUB_CULTURE, HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<SubCultureTypeDto>>() {
					}, params);
			if (response.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + response.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE + response.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return response.getBody().getData();
	}
}
