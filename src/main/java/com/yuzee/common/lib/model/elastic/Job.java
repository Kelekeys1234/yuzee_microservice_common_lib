package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.JobStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("job")
public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 838867577080650135L;
	
	@JsonProperty("job_id")
	@Field(name = "id")
	private String id;
	
	@Field(name = "user_id")
	private String userId;
	
	// this is Id of institute in case of institute job or company id in case of company job
	@Field(name = "entity_id")
	private String entityId;
	
	@Field(name = "entity_type")
	private String entityType;
		
	@Field(name = "title")
	private String title;
	
	@Field(name = "readable_id")
	private String readableId;
	
	@Field(name = "description")
	private String description;
	
	@Field(name = "requirement")
	private String requirement;
	
	@Field(name = "phone_number")
	private String phoneNumber;
	
	@Field(name = "city")
	private String city;
	
	@Field(name = "state")
	private String state;

	@Field(name = "country")
	private String country;
	
	@Field(name = "address")
	private String address;
	
	@Field(name = "latitude")
	private Double latitude;
	
	@Field(name = "longitude")
	private Double longitude;
	
	@Field(name = "category")
	private String category;
	
	@Field(name = "salary_from")
	private Double salaryFrom;
	
	@Field(name = "salary_to")
	private Double salaryTo;
	
	@Field(name = "salary_currency")
	private String salaryCurrency;
	
	@Field(name = "job_duration")
	private Integer jobDuration;
	
	@Field(name = "job_duration_type")
	private String jobDurationType;
	
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("job_start_date")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate jobStartDate;
	
	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("job_end_date")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate jobEndDate;
	
	@Field(name = "type")
	private String type;
	
	@Field(name = "status")
	private String status = JobStatus.DRAFT.name();
	
	@Field(name = "job_application_process_type")
	private String jobApplicationProcessType;
	
	@Field(name = "job_schedule")
	private String jobSchedule;
	
	@Field(name = "applicant_update_emails")
	private Set<String> applicantUpdateEmails;
	
	@Field(name = "applicant_update_website")
	private String applicantUpdateWebsite;

	@Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("application_deadline")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate applicationDeadline;
	
	@Field(name = "number_of_applicant_to_hire")
	private Integer numberOfApplicantToHire;
	
	@Field(name = "years_of_work_experience_required")
	private Integer yearsOfWorkExperienceRequired;
	
	@Field(name = "job_location")
	private String jobLocation;
	
	@Field(name = "contact_candidate_after_num_of_days")
	private Integer contactCandidateAfterNumOfDays;
	
	@Field(name = "job_setting")
	private JobSetting jobSetting;
	
	@Field(name = "job_skills", type = FieldType.Nested)
	private List<String> listOfJobSkills = new ArrayList<>();
	
	@Field(name = "job_required_tests", type = FieldType.Nested)
	private List<String> listOfJobRequiredTest = new ArrayList<>();
	
	@Field(name = "job_courses", type = FieldType.Nested)
	private List<String> listOfJobCourses = new ArrayList<>();
	
	@Field(name = "job_levels", type = FieldType.Nested)
	private List<String> listOfJobLevels = new ArrayList<>();
	
	@Field(name = "job_applications", type = FieldType.Nested)
	private List<JobApplication> listOfJobApplicants = new ArrayList<>();
	
	@Field(name = "job_certificates", type = FieldType.Nested)
	private List<String> listOfJobCertifications = new ArrayList<>();
	
	@Field(name = "job_company_cultures", type = FieldType.Nested)
	private List<String> listOfJobCompanyCultures = new ArrayList<>();
	
	@Field(name = "job_working_hours", type = FieldType.Nested)
	private List<JobWorkingHours> listOfJobWorkingHours = new ArrayList<>();
	
	@Field(name = "job_target_users", type = FieldType.Nested)
	private List<String> listOfJobTargetUsers = new ArrayList<>();
}