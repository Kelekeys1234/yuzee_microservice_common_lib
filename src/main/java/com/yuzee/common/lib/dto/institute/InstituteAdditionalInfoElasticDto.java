package com.yuzee.common.lib.dto.institute;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteAdditionalInfoElasticDto {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("student_number")
	private Long numberOfStudent;

	@JsonProperty("employee_number")
	private Long numberOfEmployee;

	@JsonProperty("teacher_number")
	private Long numberOfTeacher;

	@JsonProperty("class_number")
	private Long numberOfClassRoom;

	@JsonProperty("campus_size")
	private Integer sizeOfCampus;

	@JsonProperty("lecture_hall_number")
	private Long numberOfLectureHall;

	@JsonProperty("faculty_number")
	private Long numberOfFaculty;

	@JsonProperty("employment_rate")
	private Integer rateOfEmployment;


}
