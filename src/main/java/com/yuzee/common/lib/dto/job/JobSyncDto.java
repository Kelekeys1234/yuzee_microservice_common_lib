package com.yuzee.common.lib.dto.job;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.JobStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSyncDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 838867577080650135L;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("user_id")
	private String userId;
	
	// this is Id of institute in case of institute job or company id in case of company job
	@JsonProperty("entity_id")
	private String entityId;
	
	@JsonProperty("entity_type")
	private String entityType;
		
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("readable_id")
	private String readableId;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("requirement")
	private String requirement;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("latitude")
	private Double latitude;
	
	@JsonProperty("longitude")
	private Double longitude;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("salary_from")
	private Double salaryFrom;
	
	@JsonProperty("salary_to")
	private Double salaryTo;
	
	@JsonProperty("salary_currency")
	private String salaryCurrency;
	
	@JsonProperty("job_duration")
	private Integer jobDuration;
	
	@JsonProperty("job_duration_type")
	private String jobDurationType;
	
	@JsonProperty("job_start_date")
	@JsonFormat (pattern ="yyyy-MM-dd")
	private LocalDate jobStartDate;
	
	@JsonProperty("job_end_date")
	@JsonFormat (pattern ="yyyy-MM-dd")
	private LocalDate jobEndDate;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("status")
	private String status = JobStatus.DRAFT.name();
	
	@JsonProperty("job_application_process_type")
	private String jobApplicationProcessType;
	
	@JsonProperty("job_schedule")
	private String jobSchedule;
	
	@JsonProperty("applicant_update_emails")
	private Set<String> applicantUpdateEmails;
	
	@JsonProperty("applicant_update_website")
	private String applicantUpdateWebsite;

	@JsonProperty("application_deadline")
	@JsonFormat (pattern ="yyyy-MM-dd")
	private LocalDate applicationDeadline;
	
	@JsonProperty("number_of_applicant_to_hire")
	private Integer numberOfApplicantToHire;
	
	@JsonProperty("years_of_work_experience_required")
	private Integer yearsOfWorkExperienceRequired;
	
	@JsonProperty("job_location")
	private String jobLocation;
	
	@JsonProperty("contact_candidate_after_num_of_days")
	private Integer contactCandidateAfterNumOfDays;
	
	@JsonProperty("job_setting")
	private JobSettingDto jobSetting;
	
	@JsonProperty("job_skills")
	private List<String> listOfJobSkills = new ArrayList<>();
	
	@JsonProperty("job_required_tests")
	private List<String> listOfJobRequiredTest = new ArrayList<>();
	
	@JsonProperty("job_courses")
	private List<String> listOfJobCourses = new ArrayList<>();
	
	@JsonProperty("job_levels")
	private List<String> listOfJobLevels = new ArrayList<>();
	
	@JsonProperty("job_applications")
	private List<JobApplicationDto> listOfJobApplicants = new ArrayList<>();
	
	@JsonProperty("job_certificates")
	private List<String> listOfJobCertifications = new ArrayList<>();
	
	@JsonProperty("job_company_cultures")
	private List<String> listOfJobCompanyCultures = new ArrayList<>();
	
	@JsonProperty("job_working_hours")
	private List<JobWorkingHours> listOfJobWorkingHours = new ArrayList<>();
	
	@JsonProperty("job_target_users")
	private List<String> listOfJobTargetUsers = new ArrayList<>();
}