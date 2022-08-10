package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicationOtherRequirementVaccinationPropertyDto implements Serializable {
	
	private static final long serialVersionUID = -7360419936980921335L;
	@JsonProperty("property_id")
	private UUID _id;
	
	@NotBlank(message = "{user_application.other_requirement.property.vaccination_id.is_required}") 
	@JsonProperty("vaccination_id")
	private String vaccinationId;
	
	@JsonProperty("vaccination_name")
	private String vaccinationName;
	
	@JsonProperty("is_vaccinated")
	private String isVaccinated;
	
	@JsonProperty("certificate")
	private StorageDto certificate;
}
