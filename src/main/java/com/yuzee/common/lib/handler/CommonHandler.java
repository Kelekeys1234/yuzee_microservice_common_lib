package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.common.CountryDto;
import com.yuzee.common.lib.dto.common.CurrencyRateDto;
import com.yuzee.common.lib.dto.common.SkillDto;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.common-handler.enabled", havingValue = "true")
public class CommonHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_COUNTRY_BY_NAME = "/country/name/{countryName}";

	private static final String GET_CURRENCY_RATE_BY_CODE = "/currency/rate/{currencyCode}";

	private static final String SAVE_CURRENCY_RATE = "/currency/rate";

	private static final String GET_CHANGED_CURRENCY_RATE = "/currency/rate/changed/{hasChanged}";
	
	private static final String GET_SKILLS_BY_NAME = "/skill/name";

	private static final String MSG_ERROR_CODE = "Error response recieved from common service with error code ";
	private static final String MSG_ERROR_INVOKE_SERVICE = "Error invoking common service";
	
	public CurrencyRateDto getCurrencyRateByCurrencyCode(final String currencyCode) {
		ResponseEntity<GenericWrapperDto<CurrencyRateDto>> responseEntity = null;
		Map<String, String> params = new HashMap<>();
		try {
			params.put("currencyCode", currencyCode);
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMMON_URL).append(GET_CURRENCY_RATE_BY_CODE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<CurrencyRateDto>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw new InvokeException(MSG_ERROR_INVOKE_SERVICE);
		}
		return responseEntity.getBody().getData();
	}

	public CountryDto getCountryDetailByCountryName(String countryName){
		log.info("going to fetch countryDetails by countryName {}", countryName);
		ResponseEntity<GenericWrapperDto<CountryDto>> countryResponseDto = null;
		Map<String, String> params = new HashMap<>();
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMMON_URL).append(GET_COUNTRY_BY_NAME);
			params.put("countryName", countryName);
			countryResponseDto = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<CountryDto>>() {
					}, params);
			if (countryResponseDto.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ countryResponseDto.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ countryResponseDto.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw new InvokeException(MSG_ERROR_INVOKE_SERVICE);
		}
		return countryResponseDto.getBody().getData();
	}

	public void saveCurrencyRate(CurrencyRateDto currencyRateDto){
		ResponseEntity<GenericWrapperDto<CurrencyRateDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMMON_URL).append(SAVE_CURRENCY_RATE);
			HttpEntity<CurrencyRateDto> request = new HttpEntity<>(currencyRateDto);

			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, request,
					new ParameterizedTypeReference<GenericWrapperDto<CurrencyRateDto>>() {
					});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw new InvokeException(MSG_ERROR_INVOKE_SERVICE);
		}
	}

	public List<CurrencyRateDto> getChangedCurrencyRate(Boolean hasChanged) {
		ResponseEntity<GenericWrapperDto<List<CurrencyRateDto>>> responseEntity = null;
		Map<String, Boolean> params = new HashMap<>();
		try {
			params.put("hasChanged", hasChanged);
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMMON_URL).append(GET_CHANGED_CURRENCY_RATE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<CurrencyRateDto>>>() {
					}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw new InvokeException(MSG_ERROR_INVOKE_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<SkillDto> getSkillByNames(Set<String> skillName) {
		ResponseEntity<GenericWrapperDto<List<SkillDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMMON_URL).append(GET_SKILLS_BY_NAME);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("skill_names", skillName);
			responseEntity = restTemplate.exchange(builder.build(false).toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<SkillDto>>>() {
					});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKE_SERVICE, e);
			throw new InvokeException(MSG_ERROR_INVOKE_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
}
