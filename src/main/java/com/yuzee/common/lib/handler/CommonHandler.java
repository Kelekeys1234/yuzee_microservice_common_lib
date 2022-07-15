package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
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
import com.yuzee.common.lib.dto.CountDto;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.common.CountryDto;
import com.yuzee.common.lib.dto.common.CurrencyRateDto;
import com.yuzee.common.lib.dto.common.SkillDto;
import com.yuzee.common.lib.dto.common.VaccinationDto;
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

	private static final String GET_SKILLS_BY_IDS = "/skill/ids";

	private static final String MSG_ERROR_CODE = "Error response recieved from common service with error code ";
	private static final String MSG_ERROR_INVOKE_SERVICE = "Error invoking common service";
	
	private static final String GET_VACCINATION_BY_FILTERS = "/vaccination/search";
	
	private static final String GET_FAQ_BY_ENTITY_ID_AND_ENTITY_TYPE = "/faq/count/entityId/{entityId}/entityType/{entityType}" ;
	
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

	public List<SkillDto> getSkillByIds(Set<String> skillIds) {
		ResponseEntity<GenericWrapperDto<List<SkillDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.COMMON_URL).append(GET_SKILLS_BY_IDS);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("skill_ids", skillIds);
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
	
	public PaginationResponseDto<List<VaccinationDto>> getVaccinationByFilters(int pageNumber ,int pageSize, Set<String> vaccinationIds) {
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<VaccinationDto>>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.COMMON_URL).append(GET_VACCINATION_BY_FILTERS)
			.append("/pageNumber/").append(pageNumber).append("/pageSize/").append(pageSize);
			
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			
			if(!CollectionUtils.isEmpty(vaccinationIds)) {
				vaccinationIds.stream().forEach(e -> uriBuilder.queryParam("vaccination_id", e));
			}
			
			responseEntity = restTemplate.exchange(uriBuilder.build(false).toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<VaccinationDto>>>>() {
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
	
	public CountDto getFaqByEntityIdAndEntityType(String entityId, String entityType){
		ResponseEntity<GenericWrapperDto<CountDto>> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			Map<String, String> params = new HashMap<>();
			params.put("entityId", entityId);
			params.put("entityType", entityType);
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.COMMON_URL).append(GET_FAQ_BY_ENTITY_ID_AND_ENTITY_TYPE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<CountDto>>() {}, params);
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
