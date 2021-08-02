package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

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
	
	@JsonProperty("attachment")
	private StorageDto attachment;
}
