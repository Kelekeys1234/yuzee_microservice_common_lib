package com.yuzee.common.lib.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.company.CompanyDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.company.enabled", havingValue = "true")
public class CompanyHandler {

	@Autowired
	private RestTemplate restTemplate;

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
}
