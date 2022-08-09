package com.yuzee.common.lib.dto.storage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.EntitySubTypeEnum;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StorageEventDTO {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("entity_id")
	private String entityId;

	@JsonProperty("entity_type")
	private EntityTypeEnum entityType;
	
	@JsonProperty("entity_sub_type")
	private EntitySubTypeEnum entitySubType;
	
	@JsonProperty("stored_file_name")
	private String storedFileName;
	
	@JsonProperty("file_type")
	private String fileType;
	
	@JsonProperty("original_file_name")
	private String originalFileName;
}
