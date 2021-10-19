package com.yuzee.common.lib.dto.job;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.job.JobWorkingHours;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationWorkingHoursDto {
	
	@JsonProperty("willing_to_work_on_job_mentioned_hours")
	private boolean willingToWorkOnJobMentionedHours;
	
	@Valid
	@JsonProperty("working_hours")
	private List<JobWorkingHours> workingHours = new ArrayList<>(); 
}