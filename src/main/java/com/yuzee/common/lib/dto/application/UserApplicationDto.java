package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.institute.InstituteDto;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class UserApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "id", access = Access.READ_ONLY)
	private UUID _id;
	
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
	
	@JsonProperty("course_name")
	private String courseName;
	
	@NotNull(message = "{user_application.description_preferences.is_required}")
	@JsonProperty("description_preferences")
	private String descriptionPreferences;
	
	@NotNull(message = "{user_application.institute_id.is_required}")
	@JsonProperty("institute_id")
	private String instituteId;
	
	@JsonProperty("institute_name")
	private String instituteName;
	
	@JsonProperty("delivery_mode")
	private List<String> deliveryModes;
	
	@JsonProperty("study_mode")
	private List<String> studyModes;
	
	@NotNull(message = "{user_application.level.is_required}")
	@JsonProperty("level")
	private String level;
	
	@NotNull(message = "{user_application.why_interested.is_required}")
	@JsonProperty("why_interested")
	private String whyInterested;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("intake_date")
	private List<Date> intakeDates;
	
	@Valid
	@NotNull(message = "{user_application.location.is_required}") 
	@JsonProperty("preffered_locations")
	private List <UserApplicationLocationDto> prefferedLocations = null;
	
	@Valid
	@NotNull(message = "{user_application.preffered_courses.is_required}") 
	@JsonProperty("preffered_courses")
	private List <CourseIdDto> preferredCourseIds = null;
	
	@Valid
	@NotNull(message = "{user_application.preffered_careers.is_required}") 
	@JsonProperty("preffered_careers")
	private List <UserApplicationPrefferedCareerIdsDto> prefferedCareersIds = null;

	@JsonProperty("student_type")
	private String studentType;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("rejected_application")
	private UserApplicationRejectedDto userApplicationRejected = null;
	
	@JsonProperty("is_video_application")
	private boolean isVideoApplication;
	
	@JsonProperty("finance_details")
	private UserApplicationFinanceDetailsWapperDto financeDetails = null;
	
	@JsonProperty("scholarship")
	private UserApplicationScholarshipDto scholarship = null;
	
	@JsonProperty("other_requirements")
	private List<UserApplicationOtherRequirementRestInterfaceDto> otherRequirements = null;
	
	@JsonProperty("video_pitch")
	private List<StorageDto> videoPitch = null;
	
	@JsonProperty("recognition_for_prior_leaning")
	private RPLApplicationDto rpl = null;
	
	@JsonProperty("upskilling_applicaiton")
	private UpskillingApplicationDto upskillingApplication = null;
	
	@JsonProperty("other_details")
	private UserApplicationOtherDetailsDto otherDetails = null;
	
	@JsonProperty("institute_dto")
	private InstituteDto instituteDto = null;
	
	@JsonProperty("created_on")
	private Date createdOn;
	
	@JsonProperty("updated_on")
	private Date updatedOn;
}
