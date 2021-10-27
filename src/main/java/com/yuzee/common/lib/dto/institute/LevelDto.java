package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto implements SyncDTO {

	@JsonProperty("level_id")
	private String id;

	@JsonProperty("name")
	@NotBlank(message = "name should not be blank")
	private String name;

	@JsonProperty("code")
	@NotBlank(message = "code should not be blank")
	private String code;

	@JsonProperty("description")
	private String description;

	@JsonProperty(value = "sequence_no", access = Access.WRITE_ONLY)
	private Integer sequenceNo;

	@Override
	public String getIdentifier() {
		return this.getId();
	}

	public LevelDto(String id, String name, String code, String description) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
	}
}
