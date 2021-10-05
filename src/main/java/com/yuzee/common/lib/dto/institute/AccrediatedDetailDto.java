package com.yuzee.common.lib.dto.institute;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class AccrediatedDetailDto {
	
	@JsonProperty("accrediated_id")
	private String id;
	
	@NotNull(message = "accrediated name is required")
	@JsonProperty("accrediated_name")
	private String accrediatedName;
	
	@NotBlank(message = "accrediated_website is required")
	@JsonProperty("accrediated_website")
	private String accrediatedWebsite;
	
	@JsonProperty("storage_list")
	private List<StorageDto> storage;
	
	@NotNull(message = "entityId is required")
	@JsonProperty("entity_id")
	private String entityId;
	
	@NotNull(message = "entityType is required")
	@JsonProperty("entity_type")
	private String entityType;
	
	@JsonProperty("description")
	private String description;
}
