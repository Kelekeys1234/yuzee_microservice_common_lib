package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@EqualsAndHashCode
//@CompoundIndexes({
//  @CompoundIndex(name = "UK_N_EI_ET_ST", def = "{'name' : 1, 'entityId': 1, 'entityType': 1, 'studentType': 1}", unique = true)
//})
//@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class RPLApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private UUID _id;
	
	@JsonProperty("education_details")
	private UserEducationDto userEducation;
	
	@JsonProperty("study_time")
	private UserStudyTimeDto studyTime;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_on")
	private Date createdOn;
	
	@JsonProperty("updated_by")
	private String updatedBy;
	
	@JsonProperty("updated_on")
	private Date updatedOn ;
	
}
