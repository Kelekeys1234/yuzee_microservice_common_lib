package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.application.RPLApplicationDto;
import com.yuzee.common.lib.dto.application.UpskillingApplicationDto;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class UserApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "id", access = Access.READ_ONLY)
	private String id;
	
	@JsonProperty("applicant_id")
	private String applicantId;
	
	@JsonProperty("application_id")
	private String applicationId;
	
	@JsonProperty("application_type")
	private String applicationType;
	
	@JsonProperty("family_member_id")
	private String familyMemberId;
	
	@NotNull(message = "{user_application.type.is_required}")
	@JsonProperty("type")
	private String type;
	
	@NotNull(message = "{user_application.applying_for_type.is_required}")
	@JsonProperty("applying_for_type")
	private String applyingForType;
	
	@NotNull(message = "{user_application.course_id.is_required}")
	@JsonProperty("course_id")
	private String courseId;
	
	@NotNull(message = "{user_application.description_preferences.is_required}")
	@JsonProperty("description_preferences")
	private String descriptionPreferences;
	
	@NotNull(message = "{user_application.institute_id.is_required}")
	@JsonProperty("institute_id")
	private String instituteId;
	
	@NotNull(message = "{user_application.delivery_mode.is_required}")
	@JsonProperty("delivery_mode")
	private String deliveryMode;
	
	@NotNull(message = "{user_application.study_mode.is_required}")
	@JsonProperty("study_mode")
	private String studyMode;
	
	@NotNull(message = "{user_application.level.is_required}")
	@JsonProperty("level")
	private String level;
	
	@NotNull(message = "{user_application.why_interested.is_required}")
	@JsonProperty("why_interested")
	private String whyInterested;
	
	@NotNull(message = "{user_application.intake_date.is_required}") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("intake_date")
	private Date intakeDate;
	
	@Valid
	@NotNull(message = "{user_application.location.is_required}") 
	@JsonProperty("preffered_locations")
	private List <LocationDto> locations;
	
	@Valid
	@NotNull(message = "{user_application.preffered_courses.is_required}") 
	@JsonProperty("preffered_courses")
	private List <CourseIdDto> courseIds;
	
	@Valid
	@NotNull(message = "{user_application.preffered_careers.is_required}") 
	@JsonProperty("preffered_careers")
	private List <UserApplicationPrefferedCareerIdsListDto> careersIds;
	

	@JsonProperty("student_type")
	private String studentType;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("rejected_application")
	private UserApplicationRejectedDto userApplicationRejected;
	
	@JsonProperty("is_video_application")
	private boolean isVideoApplication;
	
	@JsonProperty("finance_details")
	private UserApplicationFinanceDetailsWapperDto financeDetails;
	
	@JsonProperty("scholarship")
	private UserApplicationScholarshipDto scholarship;
	
	@JsonProperty("other_requirements")
	private List<UserApplicationOtherRequirementDto> otherRequirements;
	
	@JsonProperty("video_pitch")
	private List<StorageDto> videoPitch;
	
	@JsonProperty("recognition_for_prior_leaning")
	private RPLApplicationDto rpl;
	
	@JsonProperty("upskilling_applicaiton")
	private UpskillingApplicationDto UpskillingApplication;
	
}
