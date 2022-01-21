package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class UserApplicationOtherRequirementPropertyValueWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("property_value")
	private String propertyValue;
	
	@Valid
	@JsonProperty("vaccination_properties")
	private List<UserApplicationOtherRequirementVaccinationPropertyDto> otherRequirementVaccinationProperties;
}
