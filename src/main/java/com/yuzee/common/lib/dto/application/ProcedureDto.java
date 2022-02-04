
package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcedureDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private UUID _id;
	
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
	
	@JsonProperty(value = "documents", access = Access.READ_ONLY)
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
	private List<ProcedureStepRestInterfaceDto> procedureStepRestInterfaceDtoList;
	
	@JsonProperty(value = "deployment_key", access = Access.READ_ONLY)
	private String deployementKey;

	@JsonProperty("is_favorite")
	private boolean isFavorite;
	
	@JsonProperty("is_default")
	private boolean isDefault;
	
	@JsonProperty("is_deleted")
	private boolean isDeleted;
	
	@JsonProperty("created_on")
	private Date createdOn;
	
	@JsonProperty("updated_on")
	private Date updatedOn = new Date();
	
}
