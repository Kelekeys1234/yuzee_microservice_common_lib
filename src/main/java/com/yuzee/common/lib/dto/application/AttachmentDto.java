package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class AttachmentDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("attachement_id")
	private String id;
	
	@NotBlank(message = "{attachement.name.is_required}") 
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("index")
	private int index;
	
	@JsonProperty("attachment")
	private StorageDto attachment;
}
