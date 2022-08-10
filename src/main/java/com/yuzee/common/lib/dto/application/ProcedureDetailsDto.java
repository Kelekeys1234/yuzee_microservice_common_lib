package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class ProcedureDetailsDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "procedure_details_id") 
	private UUID _id;
	
	@JsonProperty("use_institute_logo")
	private boolean useInstituteLogo ;
	
	@JsonProperty("institute_logo_image") 
	private StorageDto instituteLogoImage;

	@JsonProperty("institute_logo")
	private String instituteLogo ;
}
