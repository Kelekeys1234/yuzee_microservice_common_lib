package com.yuzee.common.lib.dto.institute;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InstituteWrapperDto {
	private String message;
	private String status;
	private List<CourseDto> data;
}
