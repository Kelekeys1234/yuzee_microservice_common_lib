package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApplicationScholarshipDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "scholarship_id", access = Access.READ_ONLY)
	private UUID _id;
	
	@NotNull(message = "{user_application.scholarship.recieve_scholarship_offer.is_required}") 
	@JsonProperty("recieve_scholarship_offer")
	private boolean recieveScholarshipOffer ;	
	
	@NotNull(message = "{user_application.scholarship.reason.is_required}")
	@JsonProperty("reason")
	private String reason;
	
	@JsonProperty("scholarship_pitch")
	private List<StorageDto> scholarPitch;
	
}
