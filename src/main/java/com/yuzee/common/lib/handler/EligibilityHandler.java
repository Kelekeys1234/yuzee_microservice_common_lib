package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.eligibility.EligibilityOutcomeExistsDto;
import com.yuzee.common.lib.dto.eligibility.FundingResponseDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.eligibility-handler.enabled", havingValue = "true")
public class EligibilityHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String FUNDING_NAME_BY_ID = "/funding-name";

	private static final String INVOKE_EXCEPTION = "Error invoking eligibility service {}";

	private static final String INVALID_STATUS_CODE_EXCEPTION = "Error response recieved from eligibility service with error code ";

	private static final String ELIGBILITY_TEST_OUTCOME_EXISTS = "/eligiblity/outcome/user/{user_id}/exists";
	
	public List<FundingResponseDto> getFundingByFundingNameId(List<String> fundingNameIds) {
		ResponseEntity<GenericWrapperDto<List<FundingResponseDto>>> fundingNameAPIResponse = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.ELIGIBILITY_CONNECTION_URL).append(FUNDING_NAME_BY_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			fundingNameIds.stream().forEach(e -> uriBuilder.queryParam("funding_name_ids", e));

			fundingNameAPIResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<FundingResponseDto>>>() {
					});

			if (fundingNameAPIResponse.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION + fundingNameAPIResponse.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION
						+ fundingNameAPIResponse.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException("Error invoking eligibility service");
		}
		return fundingNameAPIResponse.getBody().getData();
	}
	
	public boolean checkIfEligbilityTestOutcomeExists(String userId) {
		ResponseEntity<GenericWrapperDto<EligibilityOutcomeExistsDto>> eligbilityOutcomeExistDtoResponse = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put("user_id", userId);
			
			StringBuilder path = new StringBuilder();
			path = path.append(IConstant.ELIGIBILITY_TEST_BASE_PATH).append(ELIGBILITY_TEST_OUTCOME_EXISTS);

			eligbilityOutcomeExistDtoResponse = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<EligibilityOutcomeExistsDto>>() {},params);
			if (eligbilityOutcomeExistDtoResponse.getStatusCode().value() != 200) {
				log.error(INVALID_STATUS_CODE_EXCEPTION
						+ eligbilityOutcomeExistDtoResponse.getStatusCode().value());
				throw new InvokeException(INVALID_STATUS_CODE_EXCEPTION
						+ eligbilityOutcomeExistDtoResponse.getStatusCode().value());
			}
		} catch (InvokeException e) {
			log.error(INVOKE_EXCEPTION, e);
			throw e;
		} catch (Exception e) {
			log.error(INVOKE_EXCEPTION, e);
			throw new InvokeException("Error invoking eligibility service");
		}
		return eligbilityOutcomeExistDtoResponse.getBody().getData().isOutcomeExists();
	}

}
