package com.yuzee.common.lib.dto.user;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.collections.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.ValidList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterDto {

	@JsonProperty("id")
	private String id;

	@NotEmpty(message = "type must not be empty")
	@JsonProperty("type")
	private String type;

	@NotEmpty(message = "name must not be empty")
	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("subjects")
	ValidList<SemesterSubjectDto> subjects;
	
	
	
	public void addSubjectToValidList( SemesterSubjectDto semesterSubjectDto) {
		if (CollectionUtils.isEmpty(subjects)) {
			subjects = new ValidList<>();
		}
		subjects.add(semesterSubjectDto);
	}



	public SemesterDto(String id, @NotEmpty(message = "type must not be empty") String type,
			@NotEmpty(message = "name must not be empty") String name, String description) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
	}
}
