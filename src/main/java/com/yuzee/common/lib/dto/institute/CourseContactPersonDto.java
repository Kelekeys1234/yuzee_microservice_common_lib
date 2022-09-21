package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseContactPersonDto {

	@JsonProperty("course_contact_person_id")
	private String id;

	@JsonProperty(value = "user_id")
	@NotEmpty(message = "user_id must not be empty")
	private String userId;

	@JsonProperty(value = "user")
	private UserInitialInfoDto user;
}
