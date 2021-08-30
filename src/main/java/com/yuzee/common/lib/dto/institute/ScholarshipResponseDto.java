package com.yuzee.common.lib.dto.institute;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ScholarshipResponseDto extends ScholarshipDto {

	@JsonProperty("media")
	private List<StorageDto> media;

	@JsonProperty("levels")
	private List<LevelDto> levels;

	@JsonProperty("faculty")
	private FacultyDto faculty;

	@JsonProperty("institute")
	private InstituteSyncDTO institute;

	@JsonProperty("has_edit_access")
	private Boolean hasEditAccess;

	@JsonProperty("intakes")
	private List<ScholarshipIntakeDto> intakes;
}
