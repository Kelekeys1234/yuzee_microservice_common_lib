package com.yuzee.common.lib.dto.institute;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ScholarshipSyncDto extends ScholarshipDto implements SyncDTO{
	@JsonProperty("levels")
	private List<LevelDto> levels;

	@JsonProperty("faculty")
	private FacultyDto faculty;

	@JsonProperty("institute")
	private InstituteSyncDTO institute;

	@JsonProperty("intakes")
	private List<ScholarshipIntakeDto> scholarshipIntakes;
	
	@Override
	public String getIdentifier() {
		return this.getId();
	}
}
