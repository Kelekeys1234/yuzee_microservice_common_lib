package com.yuzee.common.lib.dto.institute;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ScholarshipElasticDto extends ScholarshipDto {
	@JsonProperty("levels")
	private List<LevelSyncDto> levels;

	@JsonProperty("faculty")
	private FacultySyncDto faculty;

	@JsonProperty("institute")
	private InstituteSyncDTO institute;

	@JsonProperty("intakes")
	private List<ScholarshipIntakeDto> scholarshipIntakes;
}
