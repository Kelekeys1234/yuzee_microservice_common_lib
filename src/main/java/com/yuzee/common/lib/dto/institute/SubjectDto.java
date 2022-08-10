package com.yuzee.common.lib.dto.institute;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

	@JsonProperty("subject_id")
	private String id;
	
	private String user_subject_id;
	
	@JsonProperty("subject_name")
	@NotBlank(message = "subject_name should not be blank")
	private String subjectName;
	
	@JsonProperty("semester_name")
	@NotBlank(message = "semester_name should not be blank")
	private String semesterName;
	
	@NotBlank(message = "grade is required") 
	private String grade;
	
	public SubjectDto(String id, String subjectName){
		this.id = id;
		this.subjectName = subjectName;
	}

}
