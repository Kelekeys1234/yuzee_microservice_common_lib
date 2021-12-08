
package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;
@Data
public class ProcedureDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id", access = Access.READ_ONLY)
	private String id;
	
	@NotBlank(message = "{procedure.name.is_required}") 
	@JsonProperty("name")
	private String name;
	
	@NotBlank(message = "{procedure.entity_id.is_required}") 
	@JsonProperty("entity_id")
	private String entityId;
	
	@NotBlank(message = "{procedure.entity_type.is_required}") 
	@JsonProperty("entity_type")
	private String entityType;
	
	@NotBlank(message = "{procedure.student_type.is_required}") 
	@JsonProperty("student_type")
	private String studentType;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("procedure_details")
	private ProcedureDetailsDto procedureDetails;
	
	@JsonProperty("documents")
	private List<StorageDto> documents;
	
	@JsonProperty("courses_and_faculties")
	private ProcedureCourseIdsAndFacultyIdsWrapperDto procedureCoursIdsAndFacultIds;
	
	@JsonProperty("location")
	private ProcedureLocationWrapperDto procedureLocationWrapperDto;
	
	@JsonProperty("accessible_by")
	private ProcedureAccessibleByWrapperDto procedureAccessibleByWrapperDto;
	
	@JsonProperty("intakes")
	private ProcedureIntakeWrapperDto procedureIntakeWrapperDto;
	
	@JsonProperty("procedure_steps")
	private List<ProcedureStepRestInterfaceDto> procedureStepDtoList;
	
	@JsonProperty("deployment_key")
	private String deployementKey;
	
	@JsonProperty("is_favorite")
	private boolean isFavorite;
	
	@JsonProperty("is_default")
	private boolean isDefault;
	
}
