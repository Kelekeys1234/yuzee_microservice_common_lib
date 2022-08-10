package com.yuzee.common.lib.dto.storage;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.thumbnail.ThumbnailsDTO;
import com.yuzee.common.lib.enumeration.EntitySubTypeEnum;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;

import lombok.Data;

@Data
public class StorageDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
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
	
	@JsonProperty("base_url")
	private String baseUrl;
	
	@JsonProperty("file_url")
	private String fileURL;
	
	@JsonProperty("mime_type")
	private String mimeType;

	@JsonProperty("thumbnails")
	private List<ThumbnailsDTO> thumbnails;
	
	@JsonProperty("has_thumbnails")
	private boolean hasThumbNails;
}
