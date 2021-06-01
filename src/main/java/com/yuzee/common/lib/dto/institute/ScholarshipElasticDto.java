package com.yuzee.common.lib.dto.institute;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ScholarshipElasticDto extends ScholarshipDto {
	@JsonProperty("levels")
	private List<LevelDto> levels;

	@JsonProperty("faculty")
	private FacultyDto faculty;

	@JsonProperty("institute")
	private InstituteElasticSearchDTO institute;

	@JsonProperty("intakes")
	private List<ScholarshipIntakeDto> scholarshipIntakes;
}
